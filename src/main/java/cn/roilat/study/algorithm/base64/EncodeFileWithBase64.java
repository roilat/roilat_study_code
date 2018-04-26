package cn.roilat.study.algorithm.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Base64;

public class EncodeFileWithBase64 {
	
	private static final int DEFAULT_SIZE = 3000;

	public static void main(String[] args) throws IOException {
		//
		String folder = ".\\src\\main\\java\\cn\\roilat\\study\\algorithm\\base64\\testFiles\\";
//		encodeAndSave(folder,"Idea快捷键麟.docx","Idea快捷键麟_bak.docx","Idea快捷键麟_encoded.txt");
//		decodeAndSave(folder,"Idea快捷键麟_encoded.txt","Idea快捷键麟_decode.docx");
		encodeAndSave(folder,"Clean Code-代码整洁之道.pdf","Clean Code-代码整洁之道1.txt");
		decodeAndSave(folder,"Clean Code-代码整洁之道1.txt","Clean Code-代码整洁之道_decode1.pdf");
//		withJavaUtilBase64Encode(folder, "Clean Code-代码整洁之道.pdf", "Clean Code-代码整洁之道.txt");
//		withJavaUtilBase64Decode(folder, "Clean Code-代码整洁之道.txt", "Clean Code-代码整洁之道_decode.pdf");
		
	}
	public static void withJavaUtilBase64Encode(String folder,String srcFile,String destFile) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(folder,destFile));
		OutputStream os = Base64.getEncoder().wrap(fos);
		FileInputStream fis = new FileInputStream(new File(folder, srcFile));
		byte[] bs = new byte[1024];
		int len;
		while((len = fis.read(bs)) > 0) {
			fos.write(bs, 0, len);
		}
		fis.close();
		fos.close();
		os.close();
	}

	
	public static void withJavaUtilBase64Decode(String folder,String srcFile,String destFile) throws IOException {
		FileInputStream fis = new FileInputStream(new File(folder,srcFile));
		InputStream is = Base64.getDecoder().wrap(fis);
		FileOutputStream fos = new FileOutputStream(new File(folder,destFile));
		byte[] bs = new byte[1024];
		int len;
		while((len = is.read(bs)) > 0) {
			fos.write(bs, 0, len);
		}
		fos.close();
		fis.close();
		is.close();
		
	}
	public static void encodeAndSave(String path,String sourceName,String targetName) throws IOException {
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
		String ss = sbOut.toString();
		System.out.println(ss);
		System.out.println(sbTemp.toString());
		System.out.println("encode...... before=" + count1 + " and after=" + count2);
		
		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
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
//		int count1 = 0;
//		int count2 = 0;
		
		String tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE);

		while (fcIn.read(target) > 0) {
			tempStr = MyBase64.encode(Arrays.copyOf(target.array(), target.position()));
			
			tempBB = ByteBuffer.wrap(tempStr.getBytes("ISO-8859-1"));
			
			sbIn.append(new String(target.array(),"GBK"));
			sbOut.append(tempStr);
			sbTemp.append(new String(tempBB.array(),"ISO-8859-1"));
//			count1 += target.position();
//			count2 += tempStr.length();
			System.out.println("encode--" + target.position());
			
			fcOut.write(tempBB);
			target.clear();
		}
		//System.out.println(sbIn.toString());
//		System.out.println(sbOut.toString());
//		System.out.println(sbTemp.toString());
//		System.out.println("encode...... before=" + count1 + " and after=" + count2);
		
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
