package cn.roilat.study.algorithm.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GzipUtils {
	private static final int BUFFER_SIZE = 2 * 1024;

	
	public static void toGZip(File file,OutputStream outputStream){
		long start = System.currentTimeMillis();

		try {
			GZIPOutputStream gis = new GZIPOutputStream(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void compress(File sourceFile, GZIPOutputStream gzos, String name, boolean KeepDirStructure)
			throws Exception {
		byte[] buf = new byte[BUFFER_SIZE];
		if (sourceFile.isFile()) {
			// 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
			//gzos.putNextEntry(new ZipEntry(name));
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1) {
				gzos.write(buf, 0, len);
			}
			// Complete the entry
			//gzos.closeEntry();
			in.close();
		} else {
			File[] listFiles = sourceFile.listFiles();
			if (listFiles == null || listFiles.length == 0) {
				// 需要保留原来的文件结构时,需要对空文件夹进行处理
				if (KeepDirStructure) {
					// 空文件夹的处理
					//gzos.putNextEntry(new ZipEntry(name + "/"));
					// 没有文件，不需要文件的copy
					//gzos.closeEntry();
				}

			} else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构
					if (KeepDirStructure) {
						// 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
						// 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
						compress(file, gzos, name + "/" + file.getName(), KeepDirStructure);
					} else {
						compress(file, gzos, file.getName(), KeepDirStructure);
					}

				}
			}
		}
	}
}
