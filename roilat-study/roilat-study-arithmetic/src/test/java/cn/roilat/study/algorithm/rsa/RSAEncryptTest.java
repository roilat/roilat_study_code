package cn.roilat.study.algorithm.rsa;

import org.junit.Test;

/**
 * https://cn.roilat.blog.csdn.net/kzcming/article/details/80104084
 * 最大加密块:117,最大解密块:128
 * 
 * @author roilat-J
 * @version $Id: RSAEncryptTest.java, v 0.1 2019年3月4日 下午5:36:11 roilat-J Exp $
 */
public class RSAEncryptTest {

    @Test
    public void testGenKeyPair() {
        RSAEncrypt.genKeyPair("D:");
    }

    @Test
    public void testLoadPublicKeyByFile() throws Exception {
        String publicKey = RSAEncrypt.loadPublicKeyByFile("D:");
        System.out.println(publicKey);
    }

    @Test
    public void testEncryptRSAPublicKeyByteArray() throws Exception {
        RSAEncrypt.genKeyPair("D:");
        String publicKey = RSAEncrypt.loadPublicKeyByFile("D:");
        String privateKey = RSAEncrypt.loadPrivateKeyByFile("D:");
        String plainTextData = "asbsdfasdfsadfsadfsadfasldfsa;dkfjsad ferpoqwierjw klsd;fals jfasdfsaldf;kaslkdfahsdfa sdflkaasbsdfasdf32dfasdsaeghjd2321";//长度不能超过117
        System.out.println(plainTextData);
        byte[] encryptData = RSAEncrypt.encrypt(RSAEncrypt.loadPublicKeyByStr(publicKey), plainTextData.getBytes());
        //System.out.println(RSAEncrypt.byteArrayToString(encryptData));
        System.out.println("encryptData=" + new String(encryptData));
        byte[] decryptData = RSAEncrypt.decrypt(RSAEncrypt.loadPrivateKeyByStr(privateKey), encryptData);
        //System.out.println(RSAEncrypt.byteArrayToString(decryptData));
        System.out.println("decryptData=" + new String(decryptData));
    }

}
