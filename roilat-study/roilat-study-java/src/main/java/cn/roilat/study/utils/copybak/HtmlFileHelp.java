package cn.roilat.study.utils.copybak;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class HtmlFileHelp {

	public static final String[] appendStr = {"","<script type=\"text/javascript\" src='js/cdfsoa.js'></script>\r</body>","<script type=\"text/javascript\" src='../js/cdfsoa.js'></script>\r</body>","<script type=\"text/javascript\" src='../../js/cdfsoa.js'></script>\r</body>"};
	
	public static final String[] blankStr = {"","---","------","---------"};
	public static final String rootPath = "F:\\hansy\\projects\\门户网站信息管理模块（一期）项目\\工程文档\\02-设计\\cdfsoa\\bak20180103";
	public static final String savePath = "F:\\hansy\\projects\\门户网站信息管理模块（一期）项目\\工程文档\\02-设计\\new";
	

	public static void main(String[] args) {
		replaceHtmlFiles(new File(rootPath),0);
	}

	public static void replaceHtmlFiles(File file,int fileLevel) {
		if(file.isFile()){
			if(file.getName().endsWith(".html") || file.getName().endsWith(".htm")){
				StringBuffer sb = readFileByNIO(file);
				int position = sb.indexOf("</body>");
				System.out.println(blankStr[fileLevel] + "File:" + file.getAbsolutePath().replace(rootPath, ""));
				sb.replace(position, position+7, appendStr[fileLevel]);
				String toSavePath = file.getAbsolutePath().replace(rootPath, savePath);
				writeFileByNIO(toSavePath,sb);
			}
		}else if(file.isDirectory()){
			File[]	subFiles = file.listFiles();
			if(subFiles != null){
				System.out.println(blankStr[fileLevel] + "Folder:" + file.getAbsolutePath().replace(rootPath, ""));
				for (File f : subFiles) {
					replaceHtmlFiles(f,fileLevel+1);
				}
			}

		}
		
	}

	public static StringBuffer readFileByNIO(File htmlFile) {//, String appendAfter
		// 第一步 获取通道
		StringBuffer sb = new StringBuffer();
		
		FileChannel channel = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(htmlFile);
			channel = fis.getChannel();
			// 文件内容的大小
			long size = channel.size();
			// 第二步 指定缓冲区
			ByteBuffer buffer = ByteBuffer.allocate(102400);
			// 第三步 将通道中的数据读取到缓冲区中
			while ((size = channel.read(buffer)) > 0) {
				//Buffer bf = buffer.flip();
				//System.out.println("limt:" + bf.limit());
				byte[] bt = buffer.array();
				sb.append(new String(bt, 0, (int) size));
				//System.out.println(new String(bt));
				buffer.clear();
			}
			buffer = null;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb;
	}

	/**
	 * 利用NIO将内容输出到文件中
	 * @param file
	 */
	public static void writeFileByNIO(String file,StringBuffer sb) {
		File f = new File(file);
		if(!f.getParentFile().exists()){
			f.getParentFile().mkdirs();
		}
		FileOutputStream fos = null;
		FileChannel fc = null;
		ByteBuffer buffer = null;
		try {
			fos = new FileOutputStream(f);
			// 第一步 获取一个通道
			fc = fos.getChannel();
			// buffer=ByteBuffer.allocate(1024);
			// 第二步 定义缓冲区
			buffer = ByteBuffer.wrap(sb.toString().getBytes());
			// 将内容写到缓冲区
			fos.flush();
			fc.write(buffer);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fc.close();
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
