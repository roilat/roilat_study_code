package org.roilat.work.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;

/**
 * 以处以iText5.x实现
 * 
 * @author roilat-J
 * @version $Id: PDFParseUtilBetaTest.java, v 0.1 2018年6月25日 上午11:10:11 roilat-J Exp $
 */
public class PDFParseUtilBetaTest {

    @SuppressWarnings("resource")
    @Test
    public void testParseFPdfs() throws IOException {
        String filePath = "D:\\文件下载\\pdf\\pdf\\";
        String savePath = null;
        PDFParseUtilBeta parseUtilBeta = new PDFParseUtilBeta();
        File file = new File(filePath);
        if(file.exists()) {
            File[] files = file.listFiles();
            int fileCount = 0;
            int success = 0;
            int fail = 0;
            List<JSONObject> list = new ArrayList<JSONObject>();
            for (File f : files) {
                if(f.getName().endsWith(".pdf")) {
                    try {
                        System.out.println("---------------------------分隔线---------------------------------------");
                        list.add(parseUtilBeta.parseSinglePdf(f));
                        savePath = "D:\\文件下载\\pdf\\success\\";
                        success += 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        savePath = "D:\\文件下载\\pdf\\fail\\";
                        fail += 1;
                    }finally {
                        FileChannel fc = new FileOutputStream(savePath + File.separator
                            + fileCount++ + "-" + f.getName()).getChannel();
                        new FileInputStream(f).getChannel().transferTo(0, f.length(), fc);
                    }
                }
            }
            //遍历所有文件
            for (JSONObject jsonObject : list) {
                System.out.println(String.format("\"---------------------------%s------------------------\"", jsonObject.get("fileName")));
                StringBuffer head = new StringBuffer();
                StringBuffer content = new StringBuffer();
                JSONArray datas = jsonObject.getJSONArray("data");
                //遍历文件中的所有行
                for (int i = 0; i < datas.size(); i++) {                    
                    JSONObject data = datas.getJSONObject(i);
                    //遍历所有列
                    Iterator<Entry<String, Object>> iter = data.entrySet().iterator();
                    //Formatter formatter = new Formatter();
                    while(iter.hasNext()) {
                        Entry<String, Object> item = iter.next();
                        String value = (String) item.getValue();
                        value = (value != null)
                            ? (value.length() > 17) ? value.substring(0, 17) + "..." : value
                            : "";
                        String key = (String) item.getKey();
                        key = (key != null)
                                ? (key.length() > 17) ? key.substring(0, 17) + "..." : key
                                    : "";
                        content.append(String.format("%1$20s", value));
                        if(i == 0) {
                            head.append(String.format("%1$20s", key));
                        }
                    }//end while
                    content.append("\n");
                }//遍历文件中的所有行 end
                System.out.println("--header--" + head.toString() + "--header--");
                System.out.println(content.toString());
                head.setLength(0);
                content.setLength(0);
            }
            System.out.println("success is " + success + ",fail is " + fail);
        }
        
    }
    
    @Test
    public void testParseSinglePdf() throws Exception {
        PDFParseUtilBeta parseUtilBeta = new PDFParseUtilBeta();
        System.out.println(parseUtilBeta.parseSinglePdf(new File("src/test/java/org/roilat/work/pdf/2015111611194967923.pdf")));
    }
    
    @Test
    public void testSplitPDFFile() throws IOException {
        String fileName = "src/test/java/org/roilat/work/pdf/2015111611194967923.pdf";
        String newFileName = "src/test/java/org/roilat/work/pdf/2015111611194967923_bak.pdf";
        PdfReader reader = new PdfReader(fileName);
        PDFParseUtilBeta.splitPDFFile(fileName, newFileName, 1, 1);
        Rectangle rt = reader.getPageSize(1);
        System.out.println(reader.getPageContent(1).length);
        System.out.println(reader.getPageResources(1));
        System.out.println(rt);

    }



}
