package cn.roilat.framework.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
	
	public static boolean existsFile(String fileName){
		return Files.exists(Paths.get(fileName));
	}
	
	public static boolean existsFile(File file){
		return file.exists() && file.isFile();
	}
	
	public static void deleteFile(String file){
		try {
			Files.delete(Paths.get(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(File file){
		file.delete();
	}
	
	
	
	@SuppressWarnings("resource")
	public static void copyFile(String source,String dest){
		FileChannel inputChannel = null;    
      	FileChannel outputChannel = null;    
        try {
          inputChannel = new FileInputStream(new File(source)).getChannel();
          outputChannel = new FileOutputStream(new File(dest)).getChannel();
          outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }catch(Exception e){
        	e.printStackTrace();
        } finally {
            try {
        	  inputChannel.close();
			  outputChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
	/***********
	 * 将原文件复制一份到目标文件.如下：
	 * File source = new File("f:\\KubBrchInfoAll_20180903.txt");
	 * File dest = new File("d:\\xx.txt");
	 * @param source
	 * @param dest
	 */
	@SuppressWarnings("resource")
	public static void copyFile(File source,File dest){
		FileChannel inputChannel = null;    
      	FileChannel outputChannel = null;    
        try {
          inputChannel = new FileInputStream(source).getChannel();
          outputChannel = new FileOutputStream(dest).getChannel();
          outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        }catch(Exception e){
        	e.printStackTrace();
        } finally {
            try {
        	  inputChannel.close();
			  outputChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
	}
	
	/************
	 * 将文件source复制到目录下
	 * @param source          文件 f:\\KubBrchInfoAll_20180903.txt
	 * @param directoryDir   目录 e:\\xx
	 */
	public static void copyFile2Directory(String source,String directoryDir){
		File directory = new File(directoryDir);
		if(!directory.exists() && !directory.isDirectory()){
			directory.mkdirs();
		}
		File sourceFile = new File(source);
		if(sourceFile.exists() && sourceFile.isFile()){
			copyFile(sourceFile,new File(directoryDir+File.separator+sourceFile.getName()));
		}
	}
	
	/**************
	 * 将原目录中的文件复制到目标目录中
	 * @param sourceDir  f:\\logs
	 * @param targetDir  e:\\log
	 */
	public static void copySourceDir2targetDic(String sourceDir,String targetDir){
		File source = new File(sourceDir);
		if(!source.exists() && !source.isDirectory()){
			//原目录不存在，直接终止
			return;
		}
		File target = new File(targetDir);
		if(!target.exists() && !target.isDirectory()){
			target.mkdirs();
		}
		File[] files = source.listFiles();
		if(files != null){
			for(File file:files){
				copyFile(file,new File(targetDir+File.separator+file.getName()));
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		copyFile("f:\\KubBrchInfoAll_20180903.txt","e:\\KubBrchInfoAll_20180903.txt");
		copyFile2Directory("f:\\KubBrchInfoAll_20180903.txt","e:\\lo");
		copySourceDir2targetDic("f:\\logs","e:\\lo");
	}
}
