/**
 * 
 */
package cn.roilat.study.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author roilat-D ZipFileUtils.java
 */
public class ZipFileUtils {

	public static void main(String[] args) {
		String s = "‪";//这个字符占三个字节
		System.out.println(s.getBytes().length);
		String error = "‪D:\\Office2010_XiTongZhiJia.zip";//D前边还有一个超级字符
		String right = "D:\\Office2010_XiTongZhiJia.zip";
		System.out.println(error.equals(right));
		compare(error, right);
		//print(error);
		//print(right);
		print("D:/test.iso");
	}

	public static void compare(String str1, String str2) {
		char[] cs1 = str1.toCharArray();
		char[] cs2 = str2.toCharArray();
		int i = 0;
		while (cs1.length < i && cs2.length < i && cs1[i] == cs2[i]) {
			System.out.println(cs1[i++]);
		}
		System.out.println(String.format("this charactor is different: index=%d, the str1[%d]=%c(%d),str2[%d]=%c(%d)",
				i, i, cs1[i],(int)cs1[i], i, cs2[i], (int)cs2[i]));
	}

	public static void print(String fullFileName) {
		ZipFile zipFile;
		try {
			System.out.println(new File(fullFileName).length());
			zipFile = new ZipFile(new File(fullFileName),Charset.forName("GBK"));
			Enumeration<? extends ZipEntry> zipEntries = zipFile.entries();
			while (zipEntries.hasMoreElements()) {
				ZipEntry zipEntry = zipEntries.nextElement();
				System.out.println(zipEntry.getName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
