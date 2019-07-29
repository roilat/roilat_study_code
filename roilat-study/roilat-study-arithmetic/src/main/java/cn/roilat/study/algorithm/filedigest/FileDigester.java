/**
 * 
 */
package cn.roilat.study.algorithm.filedigest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author roilat-D FileDigestor.java
 */
public class FileDigester {

	/**
	 * 
	 * @param fullFileName
	 * @param digestArithmetic 包含值：MD5,SHA1
	 * @return
	 */
	public String digest(String fullFileName, String digestArithmetic) {
		MessageDigest messageDigest = null;
		byte[] srcBytes = fullFileName.getBytes();
		try {
			messageDigest = MessageDigest.getInstance(digestArithmetic);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.update(srcBytes, 0, srcBytes.length);
		BigInteger bigInt = new BigInteger(1, messageDigest.digest());
		return bigInt.toString(16);
	}

	/**
	 * 
	 * @param inStream
	 * @param digestArithmetic 包含值：MD5,SHA1
	 * @return
	 */
	public String digest(InputStream inStream, String digestArithmetic) { // 获取文件的MD5值
		MessageDigest messageDigest = null;
		byte buffer[] = new byte[1024];
		int length = -1;
		try {
			messageDigest = MessageDigest.getInstance(digestArithmetic);
			while ((length = inStream.read(buffer, 0, 1024)) != -1) {
				messageDigest.update(buffer, 0, length);
			}
			inStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, messageDigest.digest());
		return bigInt.toString(16);
	}

	/**
	 * 
	 * @param file
	 * @param digestArithmetic 包含值：MD5,SHA1
	 * @return
	 * @throws FileNotFoundException
	 */
	public String digest(File file, String digestArithmetic) throws FileNotFoundException {
		return digest(new FileInputStream(file), digestArithmetic);
	}

	/**
	 * 
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		FileDigester digester = new FileDigester();
		System.out.println(digester.digest("hello world", "MD5"));// 5eb63bbbe01eeed093cb22bb8f5acdc3
		System.out.println(digester.digest(new File("C:\\Users\\TF-PC\\Desktop\\愚创-java-赵春建.docx"), "MD5"));// b7cc977e154d3a08dbfe5ef3fb07fb83
		// System.out.println(test.getFileMD5(new
		// File("D:/test.iso")));//480b62c3acd6c8a36b18d9e906cd90d2
		System.out.println(digester.digest(new File("D:/cn_windows_7_ultimate_with_sp1_x64_dvd_u_677408.iso"), "MD5"));// 480b62c3acd6c8a36b18d9e906cd90d2
		System.out.println(digester.digest(new File("D:/cn_windows_7_ultimate_with_sp1_x64_dvd_u_677408.iso"), "SHA1"));// 480b62c3acd6c8a36b18d9e906cd90d2

	}
}
