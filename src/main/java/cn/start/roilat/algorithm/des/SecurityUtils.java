
package cn.start.roilat.algorithm.des;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * javadoc for com.hansy.dataservice.api.tools.TokenUtils
 * @Copyright: 2016成都环赛信息技术有限公司 
 * @author: roilat-D
 * @since: 2016年8月28日
 */
public class SecurityUtils {

	public static String CHARSET_UTF8 = "UTF-8";
	
	public static void main(String[] args) throws IOException {
		String userName="test123";
		Map<String,String> map = SecurityUtils.genereteSecretAndToken(userName);
		String secretKey = map.get("secretKey");
		String token = map.get("token");
		System.out.println("secretKey="+secretKey);
		System.out.println("accessToken="+token);
		String phone = "13666241523";
		String certNo = "";
		String signStr = secretKey+certNo +phone+secretKey;
		System.out.println(SecurityUtils.signWithSHA(signStr));
	}
	
	public static String signWithSHA(String signData) throws IOException {
		byte[] bytes = encryptSHA(signData);
		return byte2hex(bytes);
	}
	
	private static byte[] encryptSHA(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			bytes = md.digest(data.getBytes(CHARSET_UTF8));
		} catch (GeneralSecurityException gse) {
			gse.printStackTrace();
		}
		return bytes;
	}

	private static String byte2hex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toUpperCase());
		}
		return sign.toString();
	}

	/**
	 * @description: 生成随即密码
	 * @creator: roilat-D
	 * @createDate: 2016年8月29日 
	 * @modifier:
	 * @modifiedDate:
	 * @param pwd_len 生成的密码的总长度
	 * @return
	 */
	public static synchronized String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}
	
	private static byte[] encryptMD5(String data) throws IOException {
		byte[] bytes = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			bytes = md.digest(data.getBytes(CHARSET_UTF8));
		} catch (GeneralSecurityException gse) {
			gse.printStackTrace();
		}
		return bytes;
	}
	
	/**
	 * @description: 生成密钥：userName : userName和时间戳做MD5
	 * @creator: roilat-D
	 * @createDate: 2016年8月29日 
	 * @modifier:
	 * @modifiedDate:
	 * @param userName
	 * @return
	 * @throws IOException
	 */
	private static String generateSecretKey(String userName) throws IOException{
		byte[] b = null;
		b = encryptMD5(userName+genRandomNum(10));
		return byte2hex(b);
	}
	
	
	/**
	 * @description: 票据：对票据进行SHA摘要
	 * @creator: roilat-D
	 * @createDate: 2016年8月28日 
	 * @modifier:
	 * @modifiedDate:
	 * @param secretKey
	 * @return
	 * @throws IOException
	 */
	private static String generateAccessToken(String secretKey) throws IOException{
		byte[] b = null;
		String dateTime = String.valueOf(new Date().getTime());
		b = encryptSHA(secretKey+dateTime);
		return byte2hex(b);
	}

	public static Map<String,String> genereteSecretAndToken(String userName) throws IOException{
		Map<String,String> map = new HashMap<String,String>();
		String secretKey = generateSecretKey(userName);
		String token = generateAccessToken(secretKey);
		map.put("token",token);
		map.put("secretKey", secretKey);
		return map;
	}
	
}
