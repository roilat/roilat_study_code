package cn.roilat.study.algorithm.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class EncodeFileWithBase64 {
	
	private static final int DEFAULT_SIZE = 3000;

	public static void main(String[] args) throws IOException {
		//
		String folder = ".\\src\\main\\java\\cn\\roilat\\study\\algorithm\\base64\\testFiles\\";
		encodeAndSave(folder,"Idea快捷键麟.docx","Idea快捷键麟_bak.docx","Idea快捷键麟_encoded.txt");
		decodeAndSave(folder,"Idea快捷键麟_encoded.txt","Idea快捷键麟_decode.docx");
		encodeAndSave(folder,"工作内容.txt","工作内容_bak.txt","工作内容_encode.txt");
		decodeAndSave(folder,"工作内容_encode.txt","工作内容_decode.txt");
	}
	public static void encodeAndSave(String path,String sourceName,String bakupName,String targetName) throws IOException {
		//src related
		File srcFile = new File(path,sourceName);
		FileInputStream fis = new FileInputStream(srcFile);
		FileChannel fcIn = fis.getChannel();
		
		//target related
		File destFile = new File(path,targetName);
		if(destFile.exists()) {
			destFile.delete();
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		FileChannel fcOut = fos.getChannel();
		
		//bakup related
		File backFile = new File(path,bakupName);
		if(backFile.exists()) {
			backFile.delete();
		}
		FileOutputStream bakFos = new FileOutputStream(backFile);
		FileChannel fcBak = bakFos.getChannel();
		fcIn.transferTo(0, srcFile.length(), fcBak);

		//do encode and save
		StringBuffer sbIn = new StringBuffer();
		StringBuffer sbOut = new StringBuffer();
		StringBuffer sbTemp = new StringBuffer();
		int count1 = 0;
		int count2 = 0;
		
		String tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE);

		while (fcIn.read(target) > 0) {
			tempStr = MyBase64.encode(Arrays.copyOf(target.array(), target.position()));
			
			tempBB = ByteBuffer.wrap(tempStr.getBytes("ISO-8859-1"));
			
			sbIn.append(new String(target.array(),"GBK"));
			sbOut.append(tempStr);
			sbTemp.append(new String(tempBB.array(),"ISO-8859-1"));
			count1 += target.position();
			count2 += tempStr.length();
			System.out.println("encode--" + target.position());
			
			fcOut.write(tempBB);
			target.clear();
		}
		//System.out.println(sbIn.toString());
		System.out.println(sbOut.toString());
		System.out.println(sbTemp.toString());
		System.out.println("encode...... before=" + count1 + " and after=" + count2);
		
		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
		bakFos.close();
		fcBak.close();
	}
	
	public static void decodeAndSave(String path,String sourceName,String targetName) throws IOException {
		//src related
		File srcFile = new File(path,sourceName);
		FileInputStream fis = new FileInputStream(srcFile);
		FileChannel fcIn = fis.getChannel();
		
		//target related
		File destFile = new File(path,targetName);
		if(destFile.exists()) {
			destFile.delete();
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		FileChannel fcOut = fos.getChannel();
		

		//do encode and save
		StringBuffer sbIn = new StringBuffer();
		//StringBuffer sbOut = new StringBuffer();
		int count1 = 0;
		int count2 = 0;
		
		byte[] tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE / 3 * 4);

		while (fcIn.read(target) > 0) {
			tempStr = MyBase64.decode(new String(Arrays.copyOf(target.array(), target.position()),"ISO-8859-1"));
			sbIn.append(new String(target.array(),"ISO-8859-1"));
			//sbOut.append(tempStr);
			tempBB = ByteBuffer.wrap(tempStr);
			count1 += target.position();
			count2 += tempBB.capacity();
			fcOut.write(tempBB);
			target.clear();
		}
		System.out.println(sbIn.toString());
		System.out.println("decode...... before=" + count1 + " and after=" + count2);
		//System.out.println(sbOut.toString());
		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
	}
	
}
