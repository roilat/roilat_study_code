/**
 * 
 */
package cn.roilat.study.algorithm.filedigest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

/**
 * java -jar .\fileDigester.jar MD5 FILE
 * "C:\\Users\\TF-PC\\Desktop\\愚创-java-赵春建.docx"
 * "D:/cn_windows_7_ultimate_with_sp1_x64_dvd_u_677408.iso"
 * 
 * @author roilat-D MD5Test.java
 */
public class FileDigesterMain {
	public static final List<String> SUPPORT_DIGEST_ARITHMETIC = Arrays.asList("MD5", "SHA1", "ALL");
	public static final List<String> SUPPORT_DIGEST_TYPE = Arrays.asList("STRING", "FILE");

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		if (args == null || args.length < 3) {
			System.err.println(
					"parameter error, usage: fileDigester <DigestArithmetic> <DigestType> <fullFileName1/String1> <fullFileName2/String2> ...");
			System.exit(-1);
		}
		if (!SUPPORT_DIGEST_ARITHMETIC.contains(args[0])) {
			System.err.println("parameter error, supported DigestArithmetic is: MD5, SHA1, ALL.");
			System.exit(-1);
		}
		if (!SUPPORT_DIGEST_TYPE.contains(args[1])) {
			System.err.println("parameter error, supported DigestType is: STRING, FILE.");
			System.exit(-1);
		}

		System.out.println("---------start invoke FileDigester------------");
		System.out.println("------------start parameter is:---------------");
		System.out.println("DigestArithmetic:" + args[0]);
		System.out.println("DigestType:" + args[1]);
		System.out.println("-------------end parameter is:----------------");
		System.out.println("--------------digest result:------------------");

		int i = 2;
		while (i < args.length) {
			switch (args[0]) {
			case "MD5":
			case "SHA1":
				System.out.println(args[i] + ": " + invoke(args[0], args[i], args[1]));
				break;
			case "ALL":
				System.out.println(args[i] + ": " + invoke(SUPPORT_DIGEST_ARITHMETIC.get(0), args[i], args[1]));
				System.out.println(args[i] + ": " + invoke(SUPPORT_DIGEST_ARITHMETIC.get(1), args[i], args[1]));
			}
			i++;
		}
	}

	private static String invoke(String digestArithmetic, String src, String digestType) throws FileNotFoundException {

		FileDigester digester = new FileDigester();
		return SUPPORT_DIGEST_TYPE.get(0).equals(digestType) ? digester.digest(src, digestArithmetic)
				: digester.digest(new File(src), digestArithmetic);

	}

}
