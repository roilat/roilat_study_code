package org.roilat.work;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import cn.roilat.study.utils.StringUtil;

public class Word2PdfUtil {

    private static Charset charset;
    private static String  fontFile = "/simsun.ttc,1";

    public static void word2Pdf(String filePath, String fileName) {
        if (StringUtil.isEmpty(fileName) && !new File(filePath).exists()) {
            return;
        }
        String content = null;
        String saveName = null;
        String pdfResult;
        if (fileName.endsWith(".doc")) {
            content = parseDoc2HTML(filePath, fileName);
            saveName = fileName.substring(0, fileName.length() - 4) + ".pdf";
            pdfResult = format(Jsoup.parse(content).html());
        } else if (fileName.endsWith(".docx")) {
            content = parseDocx2HTML(filePath, fileName);
            saveName = fileName.substring(0, fileName.length() - 5) + ".pdf";
            pdfResult = format(Jsoup.parse(content).html());
        } else {
            throw new RuntimeException("不支持的word文件格式！");
        }
        if (StringUtil.isEmpty(pdfResult)) {
            throw new RuntimeException("解析word文件失败！");
        }
        //Jsoup解析会有一点问题
        System.out.println(pdfResult);
        html2Pdf(filePath + File.separator + saveName, pdfResult);
    }

    public static void html2Pdf(String pdfPath, String content) {
        try {
            FileOutputStream os = new FileOutputStream(pdfPath);
            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter pdfWriter = PdfWriter.getInstance(document, os);
            document.open();
            XMLWorkerHelper.getInstance().parseXHtml(pdfWriter, document,
                new ByteArrayInputStream(content.getBytes("UTF-8")), charset,
                new XMLWorkerFontProvider() {

                    @Override
                    public Font getFont(String fontname, String encoding, boolean embedded,
                                        float size, int style, BaseColor color) {
                        BaseFont bf = null;
                        try {
                            bf = BaseFont.createFont(fontFile, BaseFont.IDENTITY_H,
                                BaseFont.EMBEDDED);
                            Font font = new Font(bf, size, style, color);
                            return font;
                        } catch (DocumentException | IOException e) {
                            e.printStackTrace();
                            return super.getFont(fontname, encoding, embedded, size, style, color);
                        }
                    }

                });
            document.close();
        } catch (DocumentException | IOException e) {
            throw new RuntimeException("写入pdf失败失败！");
        }
    }

    private static String format(String str) {
        return Jsoup.parse(str).html().replaceFirst(
            "\\<html\\>",
            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \r\n"
                          + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">  \r\n"
                          + "<html xmlns=\"http://www.w3.org/1999/xhtml\">");
    }

    private static String parseDocx2HTML(String docxPath, String fileName) {
        String picFilePath = (docxPath = docxPath.endsWith("/")
            ? docxPath.substring(0, docxPath.length() - 1)
            : docxPath) + "/imagesx/";
        File picFile = new File(picFilePath);
        if (!picFile.exists()) {
            picFile.mkdirs();
        }
        String context = null;
        try {
            InputStream is = new FileInputStream(docxPath + File.separator + fileName);
            XWPFDocument document = new XWPFDocument(is);
            //解析 XHTML配置（这里设置IURIResolver来设置图片存放的目录）
            XHTMLOptions options = XHTMLOptions.create();
            options.setExtractor(new FileImageExtractor(picFile));
            options.URIResolver(new BasicURIResolver(picFilePath));
            //将XWPFDocument转为XHTML
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            XHTMLConverter.getInstance().convert(document, outputStream, options);
            outputStream.close();
            context = outputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return context;
    }

    private static String parseDoc2HTML(String docPath, String fileName) {
        String picFilePath = (docPath = docPath.endsWith("/")
            ? docPath.substring(0, docPath.length() - 1)
            : docPath) + "/images/";
        File picFile = new File(picFilePath);
        if (!picFile.exists()) {
            picFile.mkdirs();
        }
        String context = null;
        try {
            HWPFDocument document = new HWPFDocument(
                new FileInputStream(docPath + File.separator + fileName));
            WordToHtmlConverter converter = new WordToHtmlConverter(
                DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
            converter.setPicturesManager(new PicturesManager() {

                @Override
                public String savePicture(byte[] content, PictureType pictureType,
                                          String suggestedName, float widthInches,
                                          float heightInches) {
                    File file = new File(picFilePath + suggestedName);
                    try (FileOutputStream fos = new FileOutputStream(file);) {
                        fos.write(content);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return file.getPath();
                }
            });

            converter.processDocument(document);
            Document htmlDoc = converter.getDocument();
            DOMSource source = new DOMSource(htmlDoc);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            StreamResult result = new StreamResult(outputStream);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //transformer.setOutputProperty(OutputKeys.ENCODING, "");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "html");
            transformer.transform(source, result);
            outputStream.close();
            context = outputStream.toString();
        } catch (IOException | ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
        return context;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(get());
        createPdf("C:\\Users\\wb-dtw368035\\Desktop\\test\\aaa.pdf", "C:/Users/wb-dtw368035/Desktop/aaa.html");
        //html2Pdf("C:\\Users\\wb-dtw368035\\Desktop\\test\\aaa.pdf", get());
        //Word2PdfUtil.word2Pdf("C:\\Users\\wb-dtw368035\\Desktop\\test","新建 Microsoft Word 文档.docx");
    }

    public static void createPdf(String pdfFile, String wordFile) throws Exception {
        // step 2  
        OutputStream os = new FileOutputStream(pdfFile);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocument(new File(wordFile));

        // step 3 解决中文支持  
        org.xhtmlrenderer.pdf.ITextFontResolver fontResolver = renderer.getFontResolver();
        fontResolver.addFont(fontFile, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        renderer.layout();
        renderer.createPDF(os);
        os.close();

        System.out.println("create pdf done!!");
    }

    public static String get() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  \r\n"
               + "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">  \r\n"
               + "<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + " <head> \r\n"
               + "  <style>p{margin-top:0pt;margin-bottom:1pt;}p.a{text-align:justified;}p.X1{text-align:left;margin-top:5.0pt;margin-bottom:5.0pt;}span.X1{font-family:'宋体';font-size:24.0pt;font-weight:bold;}p.X2{text-align:left;margin-top:5.0pt;margin-bottom:5.0pt;}span.X2{font-family:'宋体';font-size:18.0pt;font-weight:bold;}p.X3{text-align:left;margin-top:5.0pt;margin-bottom:5.0pt;}span.X3{font-family:'宋体';font-size:13.0pt;font-weight:bold;}p.X4{text-align:left;margin-top:5.0pt;margin-bottom:5.0pt;}span.X4{font-family:'宋体';font-size:12.0pt;font-weight:bold;}span.X1Char{font-family:'宋体';font-size:24.0pt;font-weight:bold;}span.X2Char{font-family:'宋体';font-size:18.0pt;font-weight:bold;}span.X3Char{font-family:'宋体';font-size:13.0pt;font-weight:bold;}span.X4Char{font-family:'宋体';font-size:12.0pt;font-weight:bold;}span.a3{color:#0000ff;text-decoration:underline;}p.a4{text-align:left;margin-top:5.0pt;margin-bottom:5.0pt;}span.a4{font-family:'宋体';font-size:12.0pt;}</style> \r\n"
               + " </head> \r\n" + " <body> \r\n"
               + "  <div style=\"width:595.0pt;margin-bottom:72.0pt;margin-top:72.0pt;margin-left:90.0pt;margin-right:90.0pt;\"> \r\n"
               + "   <p style=\"text-align:left;margin-top:15.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">Java</span><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">中</span><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">Word</span><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">转</span><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">PDF</span><span style=\"font-family:'Arial';font-size:25.0pt;font-weight:bold;color:#333333;\">解决方案</span></p> \r\n"
               + "   <p style=\"text-align:left;background-color:#ffffff;\"><img src=\"C:\\Users\\wb-dtw368035\\Desktop\\test/imagesx/word/media/image1.jpeg\" width=\"450.75pt\" height=\"450.75pt\"><span style=\"font-family:'Arial';font-size:13.0pt;color:#333333;\">&nbsp;</span></img></p> \r\n"
               + "   <p style=\"text-align:left;background-color:#ffffff;\"><a href=\"https://www.jianshu.com/u/09b89906cc40\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#333333;text-decoration:underline;\">GISerliang</span> </a><span style=\"font-family:'Arial';font-size:13.0pt;color:#333333;\">&nbsp;</span><span style=\"font-family:'Arial';font-size:13.0pt;color:#333333;\">关注</span></p> \r\n"
               + "   <p style=\"text-align:left;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\">2017.08.29 18:19*&nbsp;</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\">字数</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\"> 762&nbsp;</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\">阅读</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\"> 12857</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\">评论</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\"> 12</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\">喜欢</span><span style=\"font-family:'Arial';font-size:9.0pt;color:#969696;\"> 11</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">最近在做一个</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">Web</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">项目，需要用户把</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">Word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">上传然后展示到页面，但是</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">Word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">在线浏览的功能不及</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">PDF</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">，因此需要将</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">Word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换成</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">PDF</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">然后展示出来。其中遇到许多问题，特此记录，如有不妥之处请指正。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">一、实现功能</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">1</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">、</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">doc</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">、</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">docx</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">都可转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">PDF</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">2</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">、</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">含有中文的转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">PDF</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">后可显示</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">二、转换步骤</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\"> —&gt; html —&gt; pdf</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">三、使用工具（</span><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">Jar</span><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">包）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">1</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">poi</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">itext</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">（如下</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">maven</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">配置）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">作用：</span><span style=\"font-family:'Arial';font-size:12.0pt;font-weight:bold;color:#2f2f2f;\">poi</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">：用于将</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">；</span><span style=\"font-family:'Arial';font-size:12.0pt;font-weight:bold;color:#2f2f2f;\">itext</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">：将</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">poi</span><span style=\"font-family:'Arial';color:#969696;\">配置</span></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">itext</span><span style=\"font-family:'Arial';color:#969696;\">配置</span></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">poi</span><span style=\"font-family:'Arial';color:#969696;\">、</span><span style=\"font-family:'Arial';color:#969696;\">itext</span><span style=\"font-family:'Arial';color:#969696;\">版本</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">2</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">jsoup</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">（</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">maven</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">配置如下）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">作用：</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">poi</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">可以将以</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">docx</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">结尾的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">完美转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">，但是将以</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">doc</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">结尾的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">后</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">meta</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">、</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">img</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">等标签</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">不</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">闭合，导致使用</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">itext</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">将生成的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">时报错，因此需要使用</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">jsoup.parse</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">方法使</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">规范。</span></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">jsoup</span><span style=\"font-family:'Arial';color:#969696;\">配置</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">四、上代码</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">1</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">word</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">转</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">html</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">（</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">1</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">）</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">doc</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">结尾</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">word</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">（相对复杂）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">doc</span><span style=\"font-family:'Arial';color:#969696;\">结尾</span><span style=\"font-family:'Arial';color:#969696;\">word</span><span style=\"font-family:'Arial';color:#969696;\">转</span><span style=\"font-family:'Arial';color:#969696;\">html</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">（</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">2</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">）</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">docx</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">结尾</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">word</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">docx</span><span style=\"font-family:'Arial';color:#969696;\">结尾</span><span style=\"font-family:'Arial';color:#969696;\">word</span><span style=\"font-family:'Arial';color:#969696;\">转</span><span style=\"font-family:'Arial';color:#969696;\">html</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">（</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">3</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">）使用</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">jsoup</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">规范</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">html</span><span style=\"font-family:'inherit';font-size:16.0pt;font-weight:bold;color:#2f2f2f;\">并保存到磁盘</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">jsoup</span><span style=\"font-family:'Arial';color:#969696;\">规范</span><span style=\"font-family:'Arial';color:#969696;\">html</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">2</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">html</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">转</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">pdf</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">html</span><span style=\"font-family:'Arial';color:#969696;\">转</span><span style=\"font-family:'Arial';color:#969696;\">pdf</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:19.0pt;font-weight:bold;color:#2f2f2f;\">五、问题</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">太棒啦，</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">终于可以转换成</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">（可以升值加薪啦</span><span style=\"font-family:'Segoe UI Symbol';font-size:12.0pt;color:#2f2f2f;\">��</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">打脸了吧</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">别高兴太早，打开</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">doc</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">结尾的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">会发现所有的中文都不显示，只有数字和英文，本来十几页的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">最后剩下几页；打开</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">docx</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">结尾的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转换的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">会发现更悲剧，什么也不显示，一个空白的文档。捂着</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">脸继续</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">研究。。。。。。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">表急，听我慢慢道来</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">1</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、中文显示问题</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:15.0pt;font-weight:bold;color:#2f2f2f;\">原因：</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">中文在</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">中不显示是因为</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">XMLWorkHelper</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">parseXHtml</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">方法在执行过程中使用默认字体，而该字体不包含中文，因此不显示中文。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:15.0pt;font-weight:bold;color:#2f2f2f;\">解决方案：</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">parseXHtml</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">方法还有一个重载方法，其中一个参数是</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">FontProvider</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">，</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">FontProvider</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">是一个接口，扩展接口使其拥有中文显示功能（如下图）。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">parseXHtml</span><span style=\"font-family:'Arial';color:#969696;\">重载方法</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">扩展类（宋体字）</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">项目中我的扩展类中使用宋体字（正式</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">文档中使用该字体较多，</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">simsun</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">代表宋体），</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">BaseFont.createFont</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">的设置可以参考该文章</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">http://blog.csdn.net/ol_beta/article/details/5926451</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">，这里不再赘述。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">至此，中文不显示问题已解决。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">2</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">、</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">docx</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">结尾</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">word</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">转</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">pdf</span><span style=\"font-family:'inherit';font-size:18.0pt;font-weight:bold;color:#2f2f2f;\">空白</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:15.0pt;font-weight:bold;color:#2f2f2f;\">原因：</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">打开</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">docx</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">结尾的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">word</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">转化的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">html</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">文件，发现</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">body</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">中有一个或多个</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">包裹内层标签，这些</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">设置了</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">style</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">width</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">值，</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">width</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">过大导致转换的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">pdf</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">空白。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">罪魁祸首</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:11.0pt;background-color:#ffffff;\"><span style=\"font-family:'inherit';font-size:15.0pt;font-weight:bold;color:#2f2f2f;\">解决方案：</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">我用的方法最简单粗暴，在</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">jsoup</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">格式化完成后找到</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">style</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">然后替换为空。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:center;\"></p> \r\n"
               + "   <p style=\"text-align:center;background-color:#ffffff;\"><span style=\"font-family:'Arial';color:#969696;\">如</span><span style=\"font-family:'Arial';color:#969696;\">style</span><span style=\"font-family:'Arial';color:#969696;\">有</span><span style=\"font-family:'Arial';color:#969696;\">width</span><span style=\"font-family:'Arial';color:#969696;\">，替换之</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">注：该处的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">指的是</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">body</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">中最直接的子</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">，而这些</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">中的又包含的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">div</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">不影响。</span></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><br></br></p> \r\n"
               + "   <p style=\"text-align:left;margin-bottom:18.0pt;background-color:#ffffff;\"><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">大功告成，可以生成美美的</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">PDF</span><span style=\"font-family:'Arial';font-size:12.0pt;color:#2f2f2f;\">了。</span></p> \r\n"
               + "   <p></p> \r\n" + "  </div>  \r\n" + " </body>\r\n" + "</html>";
    }
}
