package cn.roilat.study.java.encode;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.List;

public class UTF8AndGBKTransUtils {
    public static byte[] utf8ToGBK_jvm(String utf8String) throws UnsupportedEncodingException, CharacterCodingException {
        CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
        CharBuffer cb = cd.decode(ByteBuffer.wrap(utf8String.getBytes("UTF-8")));
        CharsetEncoder ce = Charset.forName("GBK").newEncoder();
        ByteBuffer out = ByteBuffer.allocate((int) (ce.maxBytesPerChar()*cb.length()));
        ce.encode(cb, out , true);
        return out.array();
    }
    public static byte[] gbkToUTF8_jvm(String gbkString) throws UnsupportedEncodingException, CharacterCodingException {
        CharsetDecoder cd = Charset.forName("GBK").newDecoder();
        CharBuffer cb = cd.decode(ByteBuffer.wrap(gbkString.getBytes("GBK")));
        CharsetEncoder ce = Charset.forName("UTF-8").newEncoder();
        ByteBuffer out = ByteBuffer.allocate((int) (ce.maxBytesPerChar()*cb.length()));
        ce.encode(cb, out , true);
        return out.array();
    }
    
    public static byte[] utf8ToGBK(String utf8String) throws UnsupportedEncodingException {
        return utf8ToGBK(utf8String.getBytes("UTF-8"));

    }

    public static byte[] utf8ToGBK(byte[] bytes) throws UnsupportedEncodingException {
        List<byte[]> words = splitByteByWord(bytes);
        byte[] temp = new byte[words.size() * 3];
        int index = 0;
        if(words != null && words.size() > 0) {
            
            for (byte[] word : words) {
                switch (word.length) {
                    case 1://0xxx xxxx
                        temp[index++] = (byte) (word[0] & 0x7F);
                        break;
                    case 2://110x xxxx     10xx xxxx
                        temp[index++] = (byte) ((word[0] & 0x1C) >>> 2);
                        temp[index++] = (byte) ((word[0] & 0x03) << 6 | (word[1] & 0x3F));
                        break;
                    case 3://1110 xxxx     10xx xxxx   10xx xxxx
                        temp[index++] = (byte) ((word[0] & 0x0F) << 4 | (word[1] & 0x3C) >>> 2);
                        temp[index++] = (byte) ((word[1] & 0x03) << 6 | (word[2] & 0x3F));
                        break;                        
                    default:
                        System.out.println(String.format("存在超过2个字节的内容，gbk无法保存，我也不知道怎么处理，这个字符的字节长度是%s", word.length));
                        break;
                }
            }
        }
        byte[] result = new byte[index];
        System.arraycopy(temp, 0, result, 0, index);
        return result;
    }
    
    public static String getBytesString(byte[] bs) {
        char[] cs = "0123456789ABCDEF".toCharArray();
        StringBuffer sb = new StringBuffer();
        for (byte b : bs) {
            sb.append(cs[(b&0xF0)>>>4]).append(cs[b&0x0F]).append(" ");
        }
        return sb.toString();
    }

    private static List<byte[]> splitByteByWord(byte[] bytes) throws UnsupportedEncodingException {
        List<byte[]> result = new ArrayList<byte[]>();
        for (int i = 0; i < bytes.length;) {
            if ((bytes[i] & 0x80) == 0x00) {//1个字节,0xxx xxxx & 1000 0000为0
                result.add(new byte[] { bytes[i++] });
            } else if ((bytes[i] & 0xE0) == 0xC0) {//2个字节,110x xxxx & 1110 0000为1100 0000
                result.add(new byte[] { bytes[i++], bytes[i++] });
            } else if ((bytes[i] & 0xF0) == 0xE0) {//3个字节,1110 xxxx & 1111 0000为1110 0000
                result.add(new byte[] { bytes[i++], bytes[i++], bytes[i++] });
            } else if ((bytes[i] & 0xF8) == 0xF0) {//4个字节,1111 0xxx & 1111 1000为1111 0000
                result.add(new byte[] { bytes[i++], bytes[i++], bytes[i++], bytes[i++] });
            } else if ((bytes[i] & 0xFC) == 0xF8) {//5个字节,1111 10xx & 1111 1100为1111 1000
                result.add(new byte[] { bytes[i++], bytes[i++], bytes[i++], bytes[i++], bytes[i++] });
            } else if ((bytes[i] & 0xFE) == 0xFC) {//6个字节,1111 110x & 1111 1110为1111 1100
                result.add(new byte[] { bytes[i++], bytes[i++], bytes[i++], bytes[i++], bytes[i++], bytes[i++] });
            } else {
                throw new UnsupportedEncodingException(
                    "this input byte[] is not compatible with UTF-8");
            }

        }
        return result;
    }
}
/**
 *  一字节     0000-007F   00-07bit    0xxx xxxx
 *  二字节     0000-007F   08-11bit    110x xxxx     10xx xxxx
 *  三字节     0000-007F   11-16bit    1110 xxxx     10xx xxxx   10xx xxxx
 *  四字节     0000-007F   16-21bit    1111 0xxx     10xx xxxx   10xx xxxx   10xx xxxx
 *  五字节     0000-007F   21-26bit    1111 10xx     10xx xxxx   10xx xxxx   10xx xxxx   10xx xxxx
 *  六字节     0000-007F   26-31bit    1111 110x     10xx xxxx   10xx xxxx   10xx xxxx   10xx xxxx   10xx xxxx
 * 
 */
