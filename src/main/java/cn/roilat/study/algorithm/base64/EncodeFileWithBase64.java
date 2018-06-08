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
	private static final String DEFAULT_FILE_NAME_ENCODING_TYPE = "GBK";
	private static final String DEFAULT_FILE_ENCODE_SAVE_TYPE = "ISO-8859-1";

	public static void main(String[] args) throws IOException {
		EncodeFileWithBase64.class.getResource("11");
		//
		String toEncode = ".\\src\\main\\java\\cn\\roilat\\study\\algorithm\\base64\\testFiles\\toEncode\\";
		String encoded = ".\\src\\main\\java\\cn\\roilat\\study\\algorithm\\base64\\testFiles\\encoded\\";
		String decoded = ".\\src\\main\\java\\cn\\roilat\\study\\algorithm\\base64\\testFiles\\decoded\\";
		// encodeAndSave(folder,"Idea快捷键麟.docx","Idea快捷键麟_bak.docx","Idea快捷键麟_encoded.txt");
		// decodeAndSave(folder,"Idea快捷键麟_encoded.txt","Idea快捷键麟_decode.docx");
		//encodeAndSave(toEncode, encoded, "Clean Code-代码整洁之道_decode1.rar", "hello.txt");
		//decodeAndSave(encoded, decoded, "hello.txt", "books_bak.rar");
		// withJavaUtilBase64Encode(folder, "Clean Code-代码整洁之道.pdf", "Clean
		// Code-代码整洁之道.txt");
		// withJavaUtilBase64Decode(folder, "Clean Code-代码整洁之道.txt", "Clean
		// Code-代码整洁之道_decode.pdf");

	}

	public static void withJavaUtilBase64Encode(String sourceFolder, String srcFile, String destFile)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(sourceFolder, destFile));
		OutputStream os = Base64.getEncoder().wrap(fos);
		FileInputStream fis = new FileInputStream(new File(sourceFolder, srcFile));
		byte[] bs = new byte[1024];
		int len;
		while ((len = fis.read(bs)) > 0) {
			fos.write(bs, 0, len);
		}
		fis.close();
		fos.close();
		os.close();
	}

	public static void withJavaUtilBase64Decode(String folder, String srcFile, String destFile) throws IOException {
		FileInputStream fis = new FileInputStream(new File(folder, srcFile));
		InputStream is = Base64.getDecoder().wrap(fis);
		FileOutputStream fos = new FileOutputStream(new File(folder, destFile));
		byte[] bs = new byte[1024];
		int len;
		while ((len = is.read(bs)) > 0) {
			fos.write(bs, 0, len);
		}
		fos.close();
		fis.close();
		is.close();

	}

	public static void encodeAndSave(String sourceFolder, String targetFolder, String sourceName, String targetName)
			throws IOException {
		// src related
		File srcFile = new File(sourceFolder, sourceName);
		FileInputStream fis = new FileInputStream(srcFile);
		FileChannel fcIn = fis.getChannel();

		// target related
		File destFile = new File(targetFolder, targetName);
		if (destFile.exists()) {
			destFile.delete();
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		FileChannel fcOut = fos.getChannel();

		// do encode and save
		StringBuffer sbIn = new StringBuffer();
		StringBuffer sbOut = new StringBuffer();
		StringBuffer sbTemp = new StringBuffer();
		int count1 = 0;
		int count2 = 0;

		String tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE);

		byte[] bsTemp = sourceName.getBytes(DEFAULT_FILE_NAME_ENCODING_TYPE);
		String fileNameTemp = MyBase64.encode(bsTemp);
		bsTemp = fileNameTemp.getBytes(DEFAULT_FILE_ENCODE_SAVE_TYPE);
		byte[] bsTemp1 = Arrays.copyOf(bsTemp, bsTemp.length + 4);
		bsTemp1[bsTemp1.length - 1] = '|';
		bsTemp1[bsTemp1.length - 2] = '|';
		bsTemp1[bsTemp1.length - 3] = '|';
		bsTemp1[bsTemp1.length - 4] = '|';
		tempBB = ByteBuffer.wrap(bsTemp1);
		fcOut.write(tempBB);

		while (fcIn.read(target) > 0) {
			tempStr = MyBase64.encode(Arrays.copyOf(target.array(), target.position()));

			tempBB = ByteBuffer.wrap(tempStr.getBytes(DEFAULT_FILE_ENCODE_SAVE_TYPE));

			sbIn.append(new String(target.array(), "GBK"));
			sbOut.append(tempStr);
			sbTemp.append(new String(tempBB.array(), DEFAULT_FILE_ENCODE_SAVE_TYPE));
			count1 += target.position();
			count2 += tempStr.length();
			System.out.println("encode--" + target.position());

			fcOut.write(tempBB);
			target.clear();
		}
		// System.out.println(sbIn.toString());
		// String ss = sbOut.toString();
		// System.out.println(ss);
		// System.out.println(sbTemp.toString());
		System.out.println("encode...... before=" + count1 + " and after=" + count2);

		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
	}

	public static void encodeAndSave(String sourceFolder, String targetFolder, String sourceName, String bakupName,
			String targetName) throws IOException {
		// src related
		File srcFile = new File(sourceFolder, sourceName);
		FileInputStream fis = new FileInputStream(srcFile);
		FileChannel fcIn = fis.getChannel();

		// target related
		File destFile = new File(targetFolder, targetName);
		if (destFile.exists()) {
			destFile.delete();
		}
		FileOutputStream fos = new FileOutputStream(destFile);
		FileChannel fcOut = fos.getChannel();

		// bakup related
		File backFile = new File(targetFolder, bakupName);
		if (backFile.exists()) {
			backFile.delete();
		}
		FileOutputStream bakFos = new FileOutputStream(backFile);
		FileChannel fcBak = bakFos.getChannel();
		fcIn.transferTo(0, srcFile.length(), fcBak);

		// do encode and save
		StringBuffer sbIn = new StringBuffer();
		StringBuffer sbOut = new StringBuffer();
		StringBuffer sbTemp = new StringBuffer();
		// int count1 = 0;
		// int count2 = 0;

		String tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE);

		byte[] bsTemp = sourceName.getBytes(DEFAULT_FILE_NAME_ENCODING_TYPE);
		String fileNameTemp = MyBase64.encode(bsTemp);
		byte[] bsTemp1 = Arrays.copyOf(fileNameTemp.getBytes(DEFAULT_FILE_ENCODE_SAVE_TYPE), bsTemp.length + 4);
		bsTemp1[bsTemp1.length - 1] = '|';
		bsTemp1[bsTemp1.length - 2] = '|';
		bsTemp1[bsTemp1.length - 3] = '|';
		bsTemp1[bsTemp1.length - 4] = '|';
		tempBB = ByteBuffer.wrap(bsTemp1);
		fcOut.write(tempBB);

		while (fcIn.read(target) > 0) {
			tempStr = MyBase64.encode(Arrays.copyOf(target.array(), target.position()));

			tempBB = ByteBuffer.wrap(tempStr.getBytes(DEFAULT_FILE_ENCODE_SAVE_TYPE));

			sbIn.append(new String(target.array(), "GBK"));
			sbOut.append(tempStr);
			sbTemp.append(new String(tempBB.array(), DEFAULT_FILE_ENCODE_SAVE_TYPE));
			// count1 += target.position();
			// count2 += tempStr.length();
			System.out.println("encode--" + target.position());

			fcOut.write(tempBB);
			target.clear();
		}
		// System.out.println(sbIn.toString());
		// System.out.println(sbOut.toString());
		// System.out.println(sbTemp.toString());
		// System.out.println("encode...... before=" + count1 + " and after=" + count2);

		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
		bakFos.close();
		fcBak.close();
	}

	public static void decodeAndSave(String sourceFolder, String targetFolder, String sourceName, String targetName)
			throws IOException {
		// src related
		File srcFile = new File(sourceFolder, sourceName);
		FileInputStream fis = new FileInputStream(srcFile);
		FileChannel fcIn = fis.getChannel();

		// target related
		FileOutputStream fos = null;
		FileChannel fcOut = null;

		// do encode and save
		StringBuffer sbIn = new StringBuffer();
		// StringBuffer sbOut = new StringBuffer();
		int count1 = 0;
		int count2 = 0;

		byte[] tempStr;
		ByteBuffer tempBB;
		ByteBuffer target = ByteBuffer.allocate(DEFAULT_SIZE / 3 * 4);
		boolean firstTime = true;
		while (fcIn.read(target) > 0) {
			if (firstTime && target.position() > 0) {
				int i = 0;
				int position = 0;
				byte[] temp = Arrays.copyOf(target.array(), target.position());
				while (i < temp.length) {
					if (temp[i++] == '|') {
						position = i + 3;
						count1 -= position;
						byte[] fileNameBs = MyBase64.decode(new String(temp, 0, i - 1, DEFAULT_FILE_ENCODE_SAVE_TYPE));
						targetName = new String(fileNameBs,DEFAULT_FILE_NAME_ENCODING_TYPE);
						break;
					}
				}
				File destFile = new File(targetFolder, targetName);
				if (destFile.exists()) {
					destFile.delete();
				}
				fos = new FileOutputStream(destFile);
				fcOut = fos.getChannel();
				tempStr = MyBase64.decode(new String(Arrays.copyOfRange(target.array(), position, target.position()),
						DEFAULT_FILE_ENCODE_SAVE_TYPE));
				firstTime = false;
			} else {
				tempStr = MyBase64.decode(
						new String(Arrays.copyOf(target.array(), target.position()), DEFAULT_FILE_ENCODE_SAVE_TYPE));
			}

			sbIn.append(new String(target.array(), "ISO-8859-1"));
			// sbOut.append(tempStr);
			tempBB = ByteBuffer.wrap(tempStr);
			count1 += target.position();
			count2 += tempBB.capacity();
			fcOut.write(tempBB);
			target.clear();
		}
		// System.out.println(sbIn.toString());
		System.out.println("decode...... before=" + count1 + " and after=" + count2);
		// System.out.println(sbOut.toString());
		fis.close();
		fcIn.close();
		fos.close();
		fcOut.close();
	}

}
