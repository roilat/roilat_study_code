package cn.roilat.study.utils;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import cn.roilat.study.utils.File2HexPrintUtil;

public class File2HexPrintUtilTest {

    @Test
    public void testPrintFileByHex() {
        /**
         * 内容：
         * 你好，世界 
         * Hello world!
         * 
         * 结果：
         * E4 BD A0 E5 A5 BD EF BC 8C E4 B8 96 E7 95 8C 20 0D 0A 48 65 6C 6C 6F 20 77 6F 72 6C 64 21 
         * 
         * 结论：
         * txt文档是直接用内容中的字符串组成。
         */
        String fileName = "src/test/java/cn/roilat/study/utils/testHexPrint.txt";
        File2HexPrintUtil.printFileByHex(fileName);
    }

    @Test
    public void testReadPDF() throws UnsupportedEncodingException {
        String fileName = "src/test/java/cn/roilat/study/utils/test.pdf";

        byte[] bts = File2HexPrintUtil.readPDF(fileName, 551, 295);
        doDealContent(bts,295);

        bts = File2HexPrintUtil.readPDF(fileName, 0x4E2, 3335);
        doDealContent(bts,295);

        bts = File2HexPrintUtil.readPDF(fileName, 0x1778, 12400);
        doDealContent(bts,295);

        bts = File2HexPrintUtil.readPDF(fileName, 0x4bee, 5364);
        doDealContent(bts,295);

        bts = File2HexPrintUtil.readPDF(fileName, 0x62a7, 1470);
        doDealContent(bts,295); 
        
        //System.out.println(File2HexPrintUtil.byte2HexStr(bts, 0, bts.length));
    }

    private void doDealContent(byte[] bts,int headSize) throws UnsupportedEncodingException {
        /*byte[] res = ZLibUtils.decompress(bts);
        System.out.println(res.length + " " + new String(res, "UTF-8"));
        byte[] temp = ZLibUtils.compress(res);
        System.out.println(
            String.format("------%s-----%s------%s-----", bts.length, res.length, temp.length));*/
        
        byte[] ret = File2HexPrintUtil.flateDecode(bts,true);
        System.out.println(new String(ret,"UTF-8"));
    }
}
