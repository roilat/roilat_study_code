
package cn.roilat.study.java.encode;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileEncodingChangeTest {
	public static void main(String[] args) throws IOException {
		System.out.println(new File("ISequenceNumber.java").getAbsolutePath());
//		FileReader fr = new FileReader("./ISequenceNumber.java");
//		readFileByLines("./com/hongrui/util/sequencenumber/ISequenceNumber.java");
//		readFileByLines("./com/hongrui/util/sequencenumber/JdbcUtil.java");
//		changeGBK2UTF8("./com/hongrui/util/sequencenumber/OracleSequenceNumber.java","./com/hongrui/util/sequencenumber/OracleSequenceNumber1.java");
//		changeGBK2UTF8("./com/hongrui/util/sequencenumber/SequenceNumber.java","./com/hongrui/util/sequencenumber/SequenceNumber1.java");
//		changeGBK2UTF8("./com/hongrui/util/sequencenumber/SequenceNumberException.java","./com/hongrui/util/sequencenumber/SequenceNumberException1.java");
//		changeGBK2UTF8("./com/hongrui/util/sequencenumber/SqlserverSequenceNumber.java","./com/hongrui/util/sequencenumber/SqlserverSequenceNumber1.java");
	}
	
	public static void changeGBK2UTF8(String fileName,String newFileName) throws IOException{
		File file = new File(fileName);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bs = new byte[1024];
		int len = 0;
		while((len = bis.read(bs))>0){
			baos.write(bs, 0, len);
		}
		System.out.println(new String(baos.toString("GBK").getBytes("UTF-8"),"UTF-8"));
		FileWriter fw = new FileWriter(new File(newFileName));
		fw.write(new String(baos.toString("GBK").getBytes("UTF-8"),"UTF-8"));
		bis.close();
		baos.close();
		fw.close();
		
	}
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + new String(tempString.getBytes("GBK"),"UTF-8"));
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}

