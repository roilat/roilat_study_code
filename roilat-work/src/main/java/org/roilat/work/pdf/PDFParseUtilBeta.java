package org.roilat.work.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.LineSegment;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunk;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy.TextChunkLocation;
import com.itextpdf.text.pdf.parser.Matrix;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.Vector;

public class PDFParseUtilBeta {

    public final String TABLE_FIRST_HEAD_STRING = "序号";

    public final int    TABLE_LINE_HEIGHT       = 50;

    /**
     * 表格最大右边界值
     */
    public final int    TABLE_MAX_RIGHT         = 2000;
    /**
     * 表格最小左右边界值
     */
    public final int    TABLE_MIN_LEFT          = 0;

    /**
     * 表格行中，文本的行距差
     */
    private final int   TR_MAX_TR_LINE_SPACE    = 10;

    private List<TextChunk> parsePDF(PdfReader reader) throws IOException {
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        final List<TextChunk> result = new ArrayList<TextChunk>();
        parser.processContent(1, new LocationTextExtractionStrategy() {

            private final List<TextChunk>     locationalResult = new ArrayList<TextChunk>();
            private TextChunkLocationStrategy tclStrat         = new TextChunkLocationStrategy() {
                                                                   public TextChunkLocation createLocation(TextRenderInfo renderInfo,
                                                                                                           LineSegment baseline) {
                                                                       return new TextChunkLocationDefaultImp(
                                                                           baseline.getStartPoint(),
                                                                           baseline.getEndPoint(),
                                                                           renderInfo
                                                                               .getSingleSpaceWidth());
                                                                   }
                                                               };

            @Override
            public String getResultantText(TextChunkFilter chunkFilter) {

                Collections.sort(locationalResult);

                StringBuilder temp = new StringBuilder();
                TextChunk tmpTextChunk = null;
                Vector startLocation = null;

                StringBuilder sb = new StringBuilder();
                TextChunk lastChunk = null;
                for (TextChunk chunk : locationalResult) {
                    //temp.append("----").append(chunk.getText()).append("[").append(chunk.getStartLocation()).append(";").append(chunk.getEndLocation()).append(";").append(chunk.getLocation().getCharSpaceWidth()).append("]");
                    if (lastChunk == null) {
                        sb.append(chunk.getText());
                        temp.append(chunk.getText());
                        //获取开始位置
                        startLocation = chunk.getStartLocation();
                    } else {
                        if (sameLine(chunk.getLocation(), lastChunk.getLocation())) {
                            // we only insert a blank space if the trailing character of the previous string wasn't a space, and the leading character of the current string isn't a space
                            if (isChunkAtWordBoundary(chunk, lastChunk)
                                && !startsWithSpace(chunk.getText())
                                && !endsWithSpace(lastChunk.getText())) {
                                sb.append(' ');
                                //如果不是同一个字符串
                                tmpTextChunk = new TextChunk(temp.toString(),
                                    new TextChunkLocationDefaultImp(startLocation,
                                        lastChunk.getEndLocation(), lastChunk.getCharSpaceWidth()));
                                result.add(tmpTextChunk);
                                startLocation = chunk.getStartLocation();
                                temp.setLength(0);
                            }

                            temp.append(chunk.getText());
                            sb.append(chunk.getText());
                        } else {

                            tmpTextChunk = new TextChunk(temp.toString(),
                                new TextChunkLocationDefaultImp(startLocation,
                                    lastChunk.getEndLocation(), lastChunk.getCharSpaceWidth()));
                            result.add(tmpTextChunk);
                            startLocation = chunk.getStartLocation();
                            temp.setLength(0);
                            temp.append(chunk.getText());

                            sb.append('\n');
                            sb.append(chunk.getText());
                        }
                    }
                    lastChunk = chunk;
                }
                return sb.toString();
            }

            @Override
            public void renderText(TextRenderInfo renderInfo) {
                LineSegment segment = renderInfo.getBaseline();
                if (renderInfo.getRise() != 0) { // remove the rise from the baseline - we do this because the text from a super/subscript render operations should probably be considered as part of the baseline of the text the super/sub is relative to 
                    Matrix riseOffsetTransform = new Matrix(0, -renderInfo.getRise());
                    segment = segment.transformBy(riseOffsetTransform);
                }
                if (renderInfo.getText() != null) {
                    System.out.println("---" + renderInfo.getText());
                }
                TextChunk tc = new TextChunk(renderInfo.getText(),
                    tclStrat.createLocation(renderInfo, segment));
                //System.out.println(segment.getBoundingRectange());
                locationalResult.add(tc);
            }

        }).getResultantText();
        //System.out.println(s);
        return result;
    }

    private static boolean sameLine(TextChunkLocation tcl1, TextChunkLocation tcl2) {
        return tcl1.orientationMagnitude() == tcl2.orientationMagnitude()
               && tcl1.distPerpendicular() == tcl2.distPerpendicular();
    }

    private static boolean startsWithSpace(String str) {
        if (str.length() == 0)
            return false;
        return str.charAt(0) == ' ';
    }

    /**
     * @param str
     * @return true if the string ends with a space character, false if the string is empty or ends with a non-space character
     */
    private static boolean endsWithSpace(String str) {
        if (str.length() == 0)
            return false;
        return str.charAt(str.length() - 1) == ' ';
    }

    public JSONObject parseSinglePdf(File file) throws Exception {
        PdfReader reader = new PdfReader(new FileInputStream(file));
        List<TextChunk> list = this.parsePDF(reader);
        //System.out.println("---------------------------分隔线---------------------------------------");
        /*for (TextChunk textChunk : list) {
            System.out.println(textChunk.getText() + "(" + textChunk.getStartLocation() + "---" + textChunk.getEndLocation()+")");
        }*/

        List<TableTr> tableTrs = this.doCalcTr(list);
        /*for (Iterator<TableTr> iterator = tableTrs.iterator(); iterator.hasNext();) {
            TableTr tableTr = (TableTr) iterator.next();
            System.out.println(tableTr);
        }*/

        Collections.sort(tableTrs);
        if (tableTrs == null || tableTrs.size() <= 0) {
            throw new Exception("表头解析处理失败---" + file.getName());
        }
        TableTr firstTr = tableTrs.get(0);
        int size = docalcTH(firstTr);
        System.out.println("table's colomn is " + size + ", 表头信息如下 " + firstTr);
        for (int i = 1; i < tableTrs.size(); i++) {
            TableTr tableTr = tableTrs.get(i);
            initForTableTr(tableTr, firstTr);
            if (!doCalcTd(tableTr)) {
                throw new Exception("表格内容解析处理失败---" + file.getName());
            }
        }

        JSONObject result = new JSONObject();
        JSONArray array = new JSONArray();

        JSONObject obj;
        String[] titles = firstTr.text();
        for (int i = 1; i < tableTrs.size(); i++) {
            obj = new JSONObject();
            List<TableTd> tableTds = tableTrs.get(i).tableTds;
            for (int j = 0; j < titles.length; j++) {
                obj.put(titles[j], tableTds.get(j).text());
            }
            array.add(obj);
        }
        result.put("fileName", file.getName());
        result.put("head", titles);
        result.put("data", array);
        return result;
    }

    private void initForTableTr(TableTr tableTr, TableTr firstTr) {
        List<TableTd> list = firstTr.tableTds;
        List<TableTd> result = tableTr.tableTds;
        TableTd temp;
        for (int i = 0; i < list.size(); i++) {
            TableTd tableTd = list.get(i);
            temp = new TableTd(null, firstTr, tableTd.left, tableTd.right);
            temp.index = i;
            result.add(temp);
        }
    }

    /**
     * 表头计算
     * @param tableTr
     * @return
     */
    private int docalcTH(TableTr tableTr) {
        List<TextChunk> chunks = tableTr.chunks;
        List<TableTd> tableTds = tableTr.tableTds;
        for (TextChunk textChunk : chunks) {
            boolean ifmerged = false;
            for (TableTd tableTd : tableTds) {
                if (tableTd.merge(textChunk, true)) {
                    ifmerged = true;
                    break;
                }
            }
            if (!ifmerged) {
                tableTds.add(new TableTd(textChunk, tableTr, 0, 0));
            }
        }
        Collections.sort(tableTds);
        TableTd lastTr = null;
        for (int i = 0; i < tableTds.size(); i++) {
            TableTd tableTd = tableTds.get(i);
            if (lastTr == null) {
                tableTd.left = TABLE_MIN_LEFT;
            } else {
                tableTd.left = lastTr.endX;
                lastTr.right = tableTd.startX;
            }
            if (i == tableTds.size() - 1) {
                tableTd.right = TABLE_MAX_RIGHT;
            }
            lastTr = tableTd;
        }
        return tableTds.size();
    }

    private boolean doCalcTd(TableTr tableTr) {
        List<TextChunk> chunks = tableTr.chunks;
        List<TableTd> tableTds = tableTr.tableTds;
        for (TextChunk textChunk : chunks) {
            boolean flag = false;
            for (TableTd tableTd : tableTds) {
                if (tableTd.merge(textChunk, false)) {
                    flag = true;
                    break;
                }
            }
            //仍然失败，则返回失败
            if (!flag) {
                return false;
            }

        }
        return true;

    }

    private List<TableTr> doCalcTr(List<TextChunk> list) {
        List<TableTr> tableTrs = new ArrayList<TableTr>();

        List<TextChunk> chunksBeforeHead = new ArrayList<TextChunk>();
        TableTr tableTr;
        //find first head
        int i = 0;
        for (; i < list.size(); i++) {
            TextChunk textChunk = list.get(i);
            if (textChunk.getText().contains(TABLE_FIRST_HEAD_STRING)) {
                tableTr = new TableTr(textChunk);
                tableTrs.add(tableTr);
                break;
            } else {
                chunksBeforeHead.add(textChunk);
            }
        }
        if (tableTrs.isEmpty()) {
            return tableTrs;
        }
        //处理表格头前边的数据
        TableTr head = tableTrs.get(0);
        for (TextChunk textChunk : chunksBeforeHead) {
            head.merge(textChunk);
        }

        //处理表格头后边的数据
        for (; ++i < list.size();) {
            TextChunk textChunk = list.get(i);
            boolean ifMerged = false;
            for (TableTr tr : tableTrs) {
                if (tr.merge(textChunk)) {
                    ifMerged = true;
                    break;
                }
            }
            if (!ifMerged) {
                tableTrs.add(new TableTr(textChunk));
            }
        }

        return tableTrs;
    }

    class TableTr implements Comparable<TableTr> {
        Integer         y;
        Set<Integer>    positionYs = new HashSet<Integer>();
        Integer         startX;
        Integer         endX;
        List<TableTd>   tableTds   = new ArrayList<TableTd>();
        List<TextChunk> chunks     = new ArrayList<TextChunk>();

        private Integer maxY;
        private Integer minY;

        public TableTr(TextChunk textChunk) {
            Vector first = textChunk.getLocation().getStartLocation();
            Vector end = textChunk.getLocation().getStartLocation();
            this.positionYs.add(Math.round(first.get(Vector.I2)));
            this.startX = Math.round(first.get(Vector.I1));
            this.y = Math.round(first.get(Vector.I2));
            this.endX = Math.round(end.get(Vector.I1));
            this.maxY = this.y;
            this.minY = this.y;
            this.chunks.add(textChunk);
        }

        public boolean merge(TextChunk textChunk) {
            int tempY = Math.round(textChunk.getStartLocation().get(Vector.I2));
            int tempX1 = Math.round(textChunk.getStartLocation().get(Vector.I1));
            int tempX2 = Math.round(textChunk.getEndLocation().get(Vector.I1));
            //是否为同一个Tr
            boolean sameTr = tempY <= maxY && tempY >= minY;
            //不是同一个Tr
            Iterator<Integer> iter = positionYs.iterator();
            while (!sameTr && iter.hasNext()) {
                if (!exceed(tempY, iter.next(), TR_MAX_TR_LINE_SPACE)) {
                    sameTr = true;
                    break;
                }
            }
            //不是同行，则返回合并失败
            if (!sameTr) {
                return false;
            }

            //重新计算maxY和minY
            if (positionYs.add(tempY)) {
                maxY = tempY > maxY ? tempY : maxY;
                minY = tempY < minY ? tempY : minY;
                y = (maxY + minY) / 2;
            }

            startX = startX < tempX1 ? startX : tempX1;
            endX = endX > tempX2 ? endX : tempX2;

            this.chunks.add(textChunk);
            return true;
        }

        /**
         * x-y是否超出{-exceedTo,exceedTo}的范围
         * @param x
         * @param y
         * @param beyondTo
         * @return
         */
        public boolean exceed(float x, float y, float exceedTo) {
            return Math.abs(x - y) > exceedTo;
        }

        @Override
        public String toString() {
            List<Integer> list = new ArrayList<Integer>(positionYs);
            Collections.sort(list);
            return "TableTr [y=" + y + ", positionYs=" + list + ", startX=" + startX + ", endX="
                   + endX + ", tableTds=" + tableTds + ", maxY=" + maxY + ", minY=" + minY + "]";
        }

        @Override
        public int compareTo(TableTr o) {
            return this.y < o.y ? 1 : -1;
        }

        public String[] text() {
            String[] result = new String[tableTds.size()];
            for (int i = 0; i < tableTds.size(); i++) {
                result[i] = tableTds.get(i).text();
            }
            return result;
        }

    }

    static class TableTd implements Comparable<TableTd> {
        Integer              index;
        Integer              startX = -1;                            //文本边界                             
        Integer              endX   = -1;                            //文本边界
        Integer              left;                                   //单元格边界
        Integer              right;                                  //单元格边界
        TableTr              tableTr;
        Map<Integer, String> map    = new TreeMap<Integer, String>();

        public TableTd(TextChunk textChunk, TableTr tableTr, int left, int right) {
            this.tableTr = tableTr;
            if (textChunk != null) {
                int tempY = Math.round(textChunk.getStartLocation().get(Vector.I2));
                this.startX = Math.round(textChunk.getStartLocation().get(Vector.I1));
                this.endX = Math.round(textChunk.getEndLocation().get(Vector.I1));
                this.map.put(tempY, textChunk.getText());
            }
            this.left = left;
            this.right = right;
        }

        public boolean merge(TextChunk textChunk, boolean ifHead) {
            int tempY = Math.round(textChunk.getStartLocation().get(Vector.I2));
            int tempX1 = Math.round(textChunk.getStartLocation().get(Vector.I1));
            int tempX2 = Math.round(textChunk.getEndLocation().get(Vector.I1));
            /*
             * 如果是表头，则startX和endX已经初始过值，但是left和right没有初始过值
             * 如果不是表头，则left和right是初始过值的，但是startX和endX没有初始过值
             * (tempX2 >= startX && tempX1 <= endX)逻辑无误，慎改
             */
            boolean flag = ifHead ? (tempX2 >= startX && tempX1 <= endX)
                : left <= tempX1 && right >= tempX2;
            if (flag) {
                startX = (startX != -1 && startX < tempX1) ? startX : tempX1;
                endX = (endX != -1 && endX > tempX2) ? endX : tempX2;
                map.put(tempY, textChunk.getText());
            }
            return flag;
        }

        @Override
        public int compareTo(TableTd o) {
            return this.startX > o.startX ? 1 : -1;
        }

        @Override
        public String toString() {
            Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
            StringBuffer sb = new StringBuffer();
            while (iter.hasNext()) {
                sb.insert(0, iter.next().getValue());
            }
            return "TableTd [index=" + index + ", x={" + startX + "-" + endX + "}, boundary={"
                   + left + "-" + right + "}, text=" + sb.toString() + "]";
        }

        public String text() {
            Iterator<Entry<Integer, String>> iter = map.entrySet().iterator();
            StringBuffer sb = new StringBuffer();
            while (iter.hasNext()) {
                sb.insert(0, iter.next().getValue());
            }
            return sb.toString();
        }
    }

    /** 
     * 截取pdfFile的第from页至第end页，组成一个新的文件名 
     * @param pdfFile  需要分割的PDF
     * @param savepath  新PDF
     * @param from  起始页
     * @param end  结束页
     */
    public static void splitPDFFile(String respdfFile, String savepath, int from, int end) {
        Document document = null;
        PdfCopy copy = null;
        try {
            PdfReader reader = new PdfReader(respdfFile);
            int n = reader.getNumberOfPages();
            if (end == 0) {
                end = n;
            }
            document = new Document(reader.getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(savepath));
            document.open();
            for (int j = from; j <= end; j++) {
                System.out.println(document.newPage());
                PdfImportedPage page = copy.getImportedPage(reader, j);
                page.getBoundingBox().setBorder(2);
                page.getBoundingBox().setBorderColor(BaseColor.DARK_GRAY);
                page.setColorFill(BaseColor.BLUE);
                copy.addPage(page);
            }
            Rectangle element = new Rectangle(100, 100);
            element.setBorder(2);
            element.setBackgroundColor(BaseColor.GREEN);
            document.add(element );
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
