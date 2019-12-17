package cn.roilat.framework.utils;


import java.util.Random;
import java.util.UUID;

public class UUIDUtil {
	/******
	 * 获取32位的UUID值
	 * @return
	 */
	public static String getUuid(){
		String uuid= UUID.randomUUID().toString();
		return uuid.toString().replaceAll("-","");
	}
	
	/********
	 * 获取6位数字随机数
	 * @return
	 */
	public static int radom(){
		Random random = new Random();  
		return random.nextInt(899999) + 100000;  
	}
	
	/******
	 * 获取20位的UUID值
	 * @return
	 */
	public static String get20Uuid(){
		String uuid= UUID.randomUUID().toString();
		return uuid.toString().replaceAll("-","").substring(0,20);
	}
}
