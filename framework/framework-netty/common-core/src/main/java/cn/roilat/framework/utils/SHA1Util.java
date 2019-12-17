package cn.roilat.framework.utils;

import java.security.MessageDigest;

/************
 * 微信公众号验证，需要使用该方法
 */
public class SHA1Util {
	private static final String SHA1 = "SHA1";
	
	private static final char[] Digit = { '0', '1' , '2', '3', '4' , '5', '6', '7' , '8', '9', 'A' , 'B', 'C', 'D' , 'E', 'F'}; 
	 
	/**
	 * 将字节数组转换为十六进制字符串.
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
     * 将字节转换为十六进制字符串.
     * @param mByte
     * @return
     */ private static String byteToHexStr(byte mByte) {
    	 char[] tempArr = new char[2]; 
    	 tempArr[0] = Digit[(mByte >>> 4) & 0X0F]; 
    	 tempArr[1] = Digit[mByte & 0X0F]; 
    	 return new String(tempArr); 
     }
     
    /********
     * SHA1进行加密
     * @param str
     * @return
     */
	public static String digest(String str) {
		if (str == null) 
			return null;
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(SHA1);
			byte[] digest = messageDigest.digest(str.getBytes());
			return byteToStr(digest);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
