package cn.roilat.study.utils.copybak;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @ClassName��Crf3Des
 * @Description��
 * @company:zhph
 * @author Administrator
 * @date: 2017-4-28 ����1:45:10
 */

public class Crf3Des {
	
	private static final String KEY24 = "souHAN.6801G6922.xef.XEF";
    
    private static final String UTF8CODE = "UTF-8";
    
    private static final String DESEDE = "DESede";
	
	/**
	 * ����3DES��Կ.
	 * @param key_byte
	 * @return
	 * @throws Exception
	 */
    private static javax.crypto.SecretKey genDESKey(byte[] keyByte)
        throws Exception {
		SecretKey k = null;
        k = new SecretKeySpec(keyByte, DESEDE);
		return k;
	}
	
	/**
	 * 3DES ����(byte[]).
	 * @param key
	 * @param crypt
	 * @return
	 * @throws Exception
	 */
	private static byte[] desDecrypt(javax.crypto.SecretKey key, byte[] crypt) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(DESEDE);
		cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(crypt);
	}
	
	/**
	 * 3DES����(byte[]).
	 * @param key
	 * @param src
	 * @return
	 * @throws Exception
	 */
	private static byte[] desEncrypt(javax.crypto.SecretKey key, byte[] src) throws Exception {
        javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(DESEDE);
		cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(src);
	}
	
	/**
	 * BASE64 ����(byte[]).
	 * @param src
	 * @return
	 */
	private static String base64Encode(byte[] src) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(src);
	}
	
	/**
	 * BASE64 ����(to byte[]).
	 * @param src
	 * @return
	 */
	private static byte[] base64DecodeToBytes(String src) {
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		try {
			return decoder.decodeBuffer(src);
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * CDS���ܳ���
	 * @param src
	 * @return
	 */
	public static String cdsEncrypt(String src) {
		SecretKey deskey;
		byte[] keyByte = null;
		String result = null;
		try {
			if (src == null || "".equals(src)) {
				return src;
			}
            keyByte = KEY24.getBytes(UTF8CODE);
            byte[] srcByte = src.getBytes(UTF8CODE);
			deskey = genDESKey(keyByte);
            byte[] encrypt = desEncrypt(deskey, srcByte);
			result = base64Encode(encrypt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * CDS���ܳ���
	 * @param crypt
	 * @return
	 */
	public static String cdsDecrypt(String crypt) {
		SecretKey deskey;
		byte[] keyByte = null;
		String result = null;
		try {
			if (crypt == null || "".equals(crypt)) {
				return crypt;
			}
            keyByte = KEY24.getBytes(UTF8CODE);
            byte[] srcByte = base64DecodeToBytes(crypt);
			deskey = genDESKey(keyByte);
            byte[] decrypt = desDecrypt(deskey, srcByte);
            result = new String(decrypt, UTF8CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * �Ѳ���..ok
	 * @param args
	 */
    public static void main2(String[] args) {
		try {
            @SuppressWarnings("unused")
            String str =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?><ROWS><ROW name=\"LOAN_CONTRACT_NO\" desc=\"��ͬ���\">HF0122435465934</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"Լ����Ϣ���\">HF0122435465934</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"Լ��������\">2012-12-29</ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"��ѯ��\">������ </ROW><ROW name=\"LOAN_CONTRACT_NO\" desc=\"��ѯ����\">2012-12-20</ROW></ROWS>";
			//����ǰ
            // System.out.println(str);
			//���ܺ�
            // String strDes = cdsEncrypt(str);
            // System.out.println(strDes);
			//���ܺ�
            // System.out.println(cdsDecrypt(strDes));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}