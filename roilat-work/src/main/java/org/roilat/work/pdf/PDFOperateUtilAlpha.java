package org.roilat.work.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.pdfbox.pdfparser.PDFParser;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.util.PDFTextStripper;

import com.itextpdf.text.pdf.PdfReader;

import cn.roilat.study.utils.ZLibUtils;

/**
 * 
 * 
 * @author roilat-J
 * @version $Id: PDFOperateUtilAlpha.java, v 0.1 2018年6月25日 上午11:11:45 roilat-J Exp $
 */
public class PDFOperateUtilAlpha {

    /**
     * 通过pdfBox实现
     * @throws IOException 
     */
    public static void pdf2Doc(String srcPDFName) throws IOException {
        PDDocument doc = PDDocument.load(srcPDFName);
        int pagenumber = doc.getNumberOfPages();

        srcPDFName = srcPDFName.substring(0, srcPDFName.lastIndexOf("."));

        String dirName = srcPDFName;

        String destDocFileName = dirName + ".doc";
        createFile(destDocFileName);
        FileOutputStream fos = new FileOutputStream(destDocFileName);
        Writer writer = new OutputStreamWriter(fos, "UTF-8");
        PDFTextStripper stripper = new PDFTextStripper();

        stripper.setSortByPosition(true);

        stripper.setStartPage(1);
        stripper.setEndPage(pagenumber);
        stripper.writeText(doc, writer);
        writer.close();
        doc.close();
        System.out.println("pdf转换word成功！");
    }

    private static void createFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("目标文件已存在" + filePath);
        }
        if (filePath.endsWith(File.separator)) {
            System.out.println("目标文件不能为目录！");
        }
        if (!file.getParentFile().exists()) {
            System.out.println("目标文件所在目录不存在，准备创建它！");
            if (!file.getParentFile().mkdirs())
                System.out.println("创建目标文件所在的目录失败！");
        }
        try {
            if (file.createNewFile())
                System.out.println("创建文件成功:" + filePath);
            else
                System.out.println("创建文件失败！");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建文件失败！" + e.getMessage());
        }
    }

    public void pdf2Image(String pdfPath) {
        //将pdf装图片 并且自定义图片得格式大小
        /* File file = new File(pdfPath);
        try {
            org.apache.pdfbox.pdmodel.PDDocument doc = org.apache.pdfbox.pdmodel.PDDocument.load(file);
            PDFRenderer renderer = new PDFRenderer(doc);
            int pageCount = doc.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                BufferedImage image = renderer.renderImageWithDPI(i, 240);
                BufferedImage srcImage = resize(image, image.getWidth(), image.getHeight());
                ImageIO.write(srcImage, "PNG", new File(pngPath.replace(".",i+".")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static void parseTableOfWord(String filePath) {
        try {
            FileInputStream in = new FileInputStream(filePath);//载入文档 //如果是office2007  docx格式  
            if (!filePath.toLowerCase().endsWith("docx")) {
                return ;
            }
            //word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后     
            XWPFDocument xwpf = new XWPFDocument(in);//得到word文档的信息  
            //List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息  
            Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格 

            while (it.hasNext()) {

                XWPFTable table = it.next();
                List<XWPFTableRow> rows = table.getRows();
                //读取每一行数据  
                for (int i = 1; i < rows.size(); i++) {
                    XWPFTableRow row = rows.get(i);
                    //读取每一列数据  
                    List<XWPFTableCell> cells = row.getTableCells();
                    for (int j = 0; j < cells.size(); j++) {
                        XWPFTableCell cell = cells.get(j);
                        //输出当前的单元格的数据  
                        System.out.println(cell.getText());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 直接返回pdf文档结构中的原内容
     * 
     * @param fileName
     * @throws IOException
     */
    public static void readDirectly(String fileName) throws IOException {
        PdfReader p = new PdfReader(fileName);
        int pages = p.getNumberOfPages();
        for (int i = 1; i < pages + 1; i++) {
            byte[] bts = p.getPageContent(i);
            byte[] ret = ZLibUtils.decompress(bts);
//            System.out.println(new String(ret));
            System.out.println(new String(ret,"UTF-8"));
//            System.out.println(new String(ret,"GBK"));
        }
    }
    
    /** 
     * simply reader all the text from a pdf file.  
     * You have to deal with the format of the output text by yourself. 
     * 2008-2-25 
     * @param pdfFilePath file path 
     * @return all text in the pdf file 
     */
    public static String getTextFromPDFWithPDFBox(String pdfFilePath) {
        String result = null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(pdfFilePath);
            PDFParser parser = new PDFParser(is);
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            result = stripper.getText(document);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static void pdf2txtWithPDFBox(String file) throws Exception {
        // 是否排序  
        boolean sort = false;
        // pdf文件名  
        String pdfFile = file;
        // 输入文本文件名称  
        String textFile = null;
        // 编码方式  
        String encoding = "UTF-8";
        // 开始提取页数  
        int startPage = 1;
        // 结束提取页数  
        int endPage = Integer.MAX_VALUE;
        // 文件输入流，生成文本文件  
        Writer output = null;
        // 内存中存储的PDF Document  
        PDDocument document = null;
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件  
                URL url = new URL(pdfFile);
                //注意参数已不是以前版本中的URL.而是File。  
                document = PDDocument.load(pdfFile);
                // 获取PDF的文件名  
                String fileName = url.getFile();
                // 以原来PDF的名称来命名新产生的txt文件  
                if (fileName.length() > 4) {
                    File outputFile = new File(
                        fileName.substring(0, fileName.length() - 4) + ".txt");
                    textFile = outputFile.getName();
                }
            } catch (MalformedURLException e) {
                // 如果作为URL装载得到异常则从文件系统装载  
                //注意参数已不是以前版本中的URL.而是File。  
                document = PDDocument.load(pdfFile);
                if (pdfFile.length() > 4) {
                    textFile = pdfFile.substring(0, pdfFile.length() - 4) + ".txt";
                }
            }
            // 文件输入流，写入文件倒textFile  
            output = new OutputStreamWriter(new FileOutputStream(textFile), encoding);
            // PDFTextStripper来提取文本  
            PDFTextStripper stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序  
            stripper.setSortByPosition(sort);
            // 设置起始页  
            stripper.setStartPage(startPage);
            // 设置结束页  
            stripper.setEndPage(endPage);
            // 调用PDFTextStripper的writeText提取并输出文本  
            stripper.writeText(document, output);
        } finally {
            if (output != null) {
                // 关闭输出流  
                output.close();
            }
            if (document != null) {
                // 关闭PDF Document  
                document.close();
            }
        }
    }

    ///<summary>  
    ///读取单个或多个pdf  
    ///</summary>  
    ///<returns>文件内容字符串</returns>  
    public static String readPdfWithItext(String fileName) throws IOException {

        PdfReader p = new PdfReader(fileName);
        //从每一页读出的字符串  
        String str = null;
        //"[......]"内部字符串  
        String subStr = null;

        StringBuffer rtStr = new StringBuffer();

        //"[","]","(",")"在字符串中的位置  
        int bg = 0, ed = 0, subbg = 0, subed = 0;

        //":"前面的字符串  
//        String fc = null;
        //":"前面的字符串  
//        String bc = null;

        //取得文档总页数  
        int pg = p.getNumberOfPages();

        // ExcelIO ei = new ExcelIO();  
        for (int i = 1; i <= pg; i++) {

            bg = 0;
            ed = 0;

            //Arrays.fill(b, 0);  

            //从每一页读出的8位字节数组  
            byte[] b = new byte[0];
            //取得第i页的内容  
            b = p.getPageContent(i);

            //下一行是把每一页的取得的字节数据写入一个txt的文件,仅供研究时用  
            //System.IO.File.WriteAllBytes(Application.StartupPath + "//P" + i.ToString() + ".txt", b);  

            StringBuilder sb = new StringBuilder();

            //取得每一页的字节数组,将每一个字节转换为字符,并将数组转换为字符串  
            for (int j = 0; j < b.length; j++)
                sb.append((char) (b[j]));
            str = sb.toString();

            //return str;  

            if (str.indexOf("[") >= 0) {

                //循环寻找"["和"]",直到找不到"["为止  
                while (bg > -1) {
                    //取得下一个"["和"]"的位置  
                    bg = str.indexOf("[", ed);
                    ed = str.indexOf("]", bg + 1);

                    //如果没有下一个"["就跳出循环  
                    if (bg == -1)
                        break;

                    //取得一个"[]"里的内容,将开始寻找"("和")"的位置初始为0  
                    subStr = str.substring(bg + 1, ed);
                    rtStr.append(subStr);
                    subbg = 0;
                    subed = 0;

                    //循环寻找下一个"("和")",直到没有下一个"("就跳出循环  
                    while (subbg > -1) {
                        //取得下一对"()"的位置  
                        subbg = subStr.indexOf("(", subed);
                        subed = subStr.indexOf(")", subbg + 1);

                        //如找不到下一对就跳出  
                        if (subbg == -1)
                            break;
                        //在返回字符串后面加上新找到的字符串  
                        rtStr.append(subStr.substring(subbg + 1, subed - subbg - 1));

                    }
                    rtStr.append("|");
                }
                //return rtStr.toString();
            } else {
                //每页的行数  
                //int lineNumber = 0;
                StringBuffer rtBuf = new StringBuffer();
                while (bg > -1) {
                    //取得下一个"("和")"的位置  
                    bg = str.indexOf("(", ed);
                    ed = str.indexOf(")", bg + 1);
                    //如果没有下一个"["就跳出循环  
                    if (bg == -1)
                        break;
                    //每行加个'|'为以后分隔准备,为什么不用"/n/r",因为不需要换行功能  
                    //rtStr += str.substring(bg + 1, ed-1) + "|";  

                    String rtStrTemp = str.substring(bg + 1, ed - 1);

                    rtBuf.append(rtStrTemp);
                    rtBuf.append("|");

                }
                rtStr.append(rtBuf.toString());
            }
        }
        if (p != null) {
            p.close();
        }

        return rtStr.toString();

    }
}
