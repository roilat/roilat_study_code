package org.roilat.work.pdf;

import java.io.IOException;

import org.junit.Test;

public class PDFOperateUtilAlphaTest {

    @Test
    public void testPdf2Doc() throws IOException {
        PDFOperateUtilAlpha.pdf2Doc("src/test/java/org/roilat/work/pdf/2015111611194967923.pdf");
    }

    @Test
    public void testParseTableOfWord() throws IOException {
        PDFOperateUtilAlpha.parseTableOfWord("src/test/java/org/roilat/work/pdf/test.docx");
    }

    @Test
    public void testGetTextFromPDFWithPDFBox() {
        String str = PDFOperateUtilAlpha
            .getTextFromPDFWithPDFBox("src/test/java/org/roilat/work/pdf/2015111611194967923.pdf");
        System.out.println(str);
    }

    @Test
    public void testPdf2txtWithPDFBox() throws Exception {
        PDFOperateUtilAlpha
            .pdf2txtWithPDFBox("src/test/java/org/roilat/work/pdf/2015111611194967923.pdf");
    }

    @Test
    public void testReadPdfWithItext() throws Exception {
        String str = PDFOperateUtilAlpha
            .readPdfWithItext("src/test/java/org/roilat/work/pdf/2015111611194967923.pdf");
        System.out.println(str);

    }
}
