package cn.roilat.framework.utils;

import java.util.Random;
import java.util.UUID;

public class RandomUtil {
	
	/********
	 * 获取6位数字随机数
	 * @return
	 */
	public static int radom(){
		Random random = new Random();  
		return random.nextInt(899999) + 100000;  
	}
	
	/******
	 * 获取32位的UUID值
	 * @return
	 */
	public static String getRandom(){
		String uuid= UUID.randomUUID().toString();
		return uuid.toString().replaceAll("-","");
	}
	
	/******
	 * 获取指定长度的随机数
	 * @return
	 */
	public static String getRandom(int lenth){
		return getRandom().substring(0,lenth);
	}
	
	public static void main(String[] args) {
		System.out.println(radom());
	}
}
