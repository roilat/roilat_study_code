package cn.roilat.study.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.InflaterInputStream;

public class File2HexPrintUtil {
    private static int BUFFER_SIZE = 1024;


    public static void printFileByHex(String fileName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            byte[] bts = new byte[1024];
            int len;
            while ((len = fis.read(bts)) > 0) {
                System.out.println(byte2HexStr(bts, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    public static byte[] readPDF(String fileName,int offset,int size) {
        
        if(size <= 0) {
            return new byte[0];
        }
        byte[] bts = new byte[BUFFER_SIZE];
        FileInputStream fis = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            fis = new FileInputStream(fileName);
            fis.skip(551);
            int remain = size;
            int end = remain > BUFFER_SIZE ? BUFFER_SIZE : remain;
            int n;
            while(end > 0 && remain > 0 && (n = fis.read(bts,0,end)) > 0 ) {
                baos.write(bts, 0, n);
                remain -= n;
                end = remain > BUFFER_SIZE ? BUFFER_SIZE : remain;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return baos.toByteArray();

    }
    

    public static String byte2HexStr(byte[] bts, int offset, int len) {
        StringBuffer ret = new StringBuffer();
        char[] cs = "0123456789ABCDEF".toCharArray();
        if (offset < 0 || len < 0 || offset + len < bts.length) {
            return null;
        }
        byte temp;
        for (int i = 0; i < len; i++) {
            temp = bts[i + offset];
            ret.append(cs[temp >>> 4 & 0x0F]).append(cs[temp & 0x0F]).append(" ");
        }
        return ret.toString();
    }
    
    /**
     * com.itextpdf.text.pdf.PdfReader.FlateDecode(final byte in[], final boolean strict)
     * 
     * @param in
     * @param strict
     * @return
     */
    public static byte[] flateDecode(final byte in[], final boolean strict) {
        ByteArrayInputStream stream = new ByteArrayInputStream(in);
        InflaterInputStream zip = new InflaterInputStream(stream);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte b[] = new byte[strict ? 4092 : 1];
        try {
            int n;
            while ((n = zip.read(b)) >= 0) {
                out.write(b, 0, n);
            }
            zip.close();
            out.close();
            return out.toByteArray();
        }
        catch (Exception e) {
            if (strict)
                return null;
            return out.toByteArray();
        }
        finally {
            try {
                zip.close();
            } catch (IOException ex) {
            }
            try {
                out.close();
            } catch (IOException ex) {
            }
        }
    }
}
