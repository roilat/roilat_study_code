package cn.roilat.study.j2ee.http.clientpool;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;


/**
 * 璇锋眰鍙傛暟瀹夊叏鍔犵绫� Created by guowei.lu on 2016-9-29.
 */
public class Signature {

    private static final char   SEPERATOR   = (char) 1;
    private static final char   DELIMITER   = '\n';
    private static final byte[] EMPTY_BYTES = new byte[] {};
    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final String MD5         = "MD5";
    // 鐢ㄦ潵灏嗗瓧鑺傝浆鎹㈡垚 16 杩涘埗琛ㄧず鐨勫瓧绗�
    private static char         hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                                                'e', 'f' };

    private String method;

    private String timestamp;

    private String nonce;

    private String path;

    private TreeMap<String, String> parameter;

    private String secretKey;

    private Signature(){
        parameter = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
    }

    public static Signature newInstance() {
        return new Signature();
    }

    public Signature path(String path) {
        this.path = path;
        return this;
    }

    public Signature method(String method) {
        this.method = method;
        return this;
    }

    public Signature secretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    /**
     * hmacsha256鍔犵绠楁硶
     * 
     * @return
     */
    public String sign() {
        // 缁勮绛惧悕涓�
        ByteArrayOutputStream output = this.buildByteStream();
        return hmacSha256(output.toByteArray());
    }

    /**
     * md5鍔犵绠楁硶
     * 
     * @return
     */
    public String signMd5() {
        // 缁勮绛惧悕涓�
        ByteArrayOutputStream output = this.buildByteStream();
        // 鏈�鍚庡姞涓婂瘑閽ヤ覆
        output.write(DELIMITER);
        try {
            output.write(this.secretKey.getBytes(Consts.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return md5hex(output.toByteArray());
    }

    /**
     * 鎸夊姞绛剧畻娉曡姹傜粍瑁呯鍚嶄覆
     * 
     * @return
     */
    private ByteArrayOutputStream buildByteStream() {
        byte[] parameterBytes = assembleParameter();
        this.timestamp = this.currentNow();
        this.nonce = StringUtils.join(String.valueOf(System.nanoTime()), RandomStringUtils.randomNumeric(4));
        // 缁勮绛惧悕涓�
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            output.write(this.method.getBytes(Consts.UTF_8));
            output.write(DELIMITER);
            output.write(this.timestamp.getBytes(Consts.UTF_8));
            output.write(DELIMITER);
            output.write(this.nonce.getBytes(Consts.UTF_8));
            output.write(DELIMITER);
            output.write(this.path.getBytes(Consts.UTF_8));
            if (ArrayUtils.isNotEmpty(parameterBytes)) {
                output.write(DELIMITER);
                output.write(parameterBytes);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return output;
    }

    public void addParameter(String name, String value) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(name)) {
            return;
        }
        if (parameter.containsKey(name)) {
            StringBuilder sb = new StringBuilder();
            sb.append(parameter.get(name)).append(SEPERATOR).append(value);
            parameter.put(name, sb.toString());
            return;
        }
        parameter.put(name, value);
    }

    private byte[] assembleParameter() {
        if (parameter.isEmpty()) {
            return EMPTY_BYTES;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : parameter.entrySet()) {
            if (StringUtils.contains(entry.getValue(), SEPERATOR)) {
                String[] arr = StringUtils.split(entry.getValue(), SEPERATOR);
                List<String> list = new ArrayList<String>();
                for (String element : arr) {
                    list.add(element);
                }
                Collections.sort(list);
                for (String str : list) {
                    sb.append("&").append(String.format("%s=%s", entry.getKey(), str));
                }
            } else {
                sb.append("&").append(String.format("%s=%s", entry.getKey(), entry.getValue()));
            }
        }
        String content = sb.substring(1);
        return content.getBytes(Consts.UTF_8);
    }

    private String currentNow() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
        return dateTimeFormatter.toString();
    }

    private String hmacSha256(byte[] message) {
        byte[] secretKeyBytes = this.secretKey.getBytes(Consts.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(secretKeyBytes, HMAC_SHA256);
        Mac mac;
        try {
            mac = Mac.getInstance(HMAC_SHA256);
            mac.init(secretKeySpec);
            mac.update(message);
            byte[] digestBytes = Base64.encodeBase64(mac.doFinal());
            return new String(digestBytes, Consts.UTF_8);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    private String md5hex(byte[] message) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MD5);
            messageDigest.update(message);
            byte[] digest = messageDigest.digest();
            int j = digest.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digest[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getNonce() {
        return nonce;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
