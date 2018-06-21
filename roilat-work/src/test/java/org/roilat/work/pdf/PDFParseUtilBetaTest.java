package org.roilat.work.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import org.junit.Test;

public class PDFParseUtilBetaTest {

    @SuppressWarnings("resource")
    @Test
    public void testParseSinglePdf() throws IOException {
        String filePath = "D:\\文件下载\\pdf\\pdf\\";
        String savePath = null;
        PDFParseUtilBeta parseUtilBeta = new PDFParseUtilBeta();
        File file = new File(filePath);
        if(file.exists()) {
            File[] files = file.listFiles();
            int i = 0;
            int success = 0;
            int fail = 0;
            for (File f : files) {
                if(f.getName().endsWith(".pdf")) {
                    try {
                        System.out.println("---------------------------分隔线---------------------------------------");
                        System.out.println(parseUtilBeta.parseSinglePdf(f));
                        savePath = "D:\\文件下载\\pdf\\success\\";
                        success += 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                        savePath = "D:\\文件下载\\pdf\\fail\\";
                        fail += 1;
                    }finally {
                        FileChannel fc = new FileOutputStream(savePath + File.separator
                            + i++ + "-" + f.getName()).getChannel();
                        new FileInputStream(f).getChannel().transferTo(0, f.length(), fc);
                    }
                }
            }
            System.out.println("success is " + success + ",fail is " + fail);
        }
        
    }

}
