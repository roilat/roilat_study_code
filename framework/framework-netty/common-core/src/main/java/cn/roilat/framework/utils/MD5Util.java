package cn.roilat.framework.utils;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 * @author jiang.li
 * @date 2013-12-17 14:09
 */
public class MD5Util {

	 /**全局数组**/
    private final static String[] strDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

    /**
     * 返回形式为数字跟字符串
     * @param bByte
     * @return
     */
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    /**
     * 转换字节数组为16进制字串
     * @param bByte
     * @return
     */
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    } 
    
    /**
     * 加密-16位小写
     * @param str
     * @return
     */
    public static String getMD5Code16(String str) {  
        return getMD5Code(str).substring(8, 24).toLowerCase();
    } 

    /**
     * MD5加密
     * @param str 待加密的字符串
     * @return
     */
    public static String getMD5Code(String str) {
        String result = null;
        try {
        	result = new String(str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteToString(md.digest(str.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    /**
     * MD5加密
     * @param str 待加密的字符串
     * @param lowerCase 大小写
     * @return
     */
    public static String getMD5Code(String str,boolean lowerCase) {
        String result = null;
        try {
        	result = new String(str);
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byteToString(md.digest(str.getBytes()));
            if(lowerCase){
            	result = result.toLowerCase();	
            }
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
