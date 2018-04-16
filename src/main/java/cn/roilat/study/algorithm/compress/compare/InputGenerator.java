package cn.roilat.study.algorithm.compress.compare;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

/**
 * Create an input test file out of a local JDK docs directory (by concatenating
 * all its files into one file)
 */
public class InputGenerator {
	private static final String JAVADOC_PATH = "D:/WorkSpace/sofaTest";
	public static final File FILE_PATH = new File("D:/temp");

	static {
		try {
			if (!FILE_PATH.exists()) {
				FILE_PATH.mkdirs();
				new TestParent().copy(new File(JAVADOC_PATH),FILE_PATH);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void makeJavadocFile() throws IOException {
		try (OutputStream os = new BufferedOutputStream(new FileOutputStream(FILE_PATH), 65536)) {
			appendDir(os, new File(JAVADOC_PATH));
			os.flush();
			os.close();
		}
		System.out.println("Javadoc file created");
	}

	private static void appendDir(final OutputStream os, final File root) throws IOException {
		for (File f : root.listFiles()) {
			if (f.isDirectory())
				appendDir(os, f);
			else
				Files.copy(f.toPath(), os);
		}
	}
}
