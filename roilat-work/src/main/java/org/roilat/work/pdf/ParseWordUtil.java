package org.roilat.work.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableCell;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.hwpf.usermodel.TableRow;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ParseWordUtil {
    
    enum DocType{
        DOCX(".docx"),
        DOC(".doc");
        String fileSuffix;
        DocType(String fileSuffix){
            this.fileSuffix = fileSuffix;
        }
        public String toString() {
            return this.fileSuffix;
        }
    }

    @SuppressWarnings("resource")
    public static void parseWords(String pdfPath, String successPath, String failPath,
                                  String firstTitleName,DocType docType) throws IOException {
        String savePath = null;
        File file = new File(pdfPath);
        if (file.exists()) {
            File[] files = file.listFiles();
            int fileCount = 0;
            int success = 0;
            int fail = 0;
            List<JSONObject> list = new ArrayList<JSONObject>();
            for (File f : files) {
                if (f.getName().endsWith(docType.toString())) {
                    try {
                        JSONObject obj = null;
                        if (DocType.DOCX.equals(docType)) {
                            obj = parseSingleDocx(f, firstTitleName);
                        }else if (DocType.DOC.equals(docType)){
                            obj = parseSingleDoc(f, firstTitleName);
                        }else {
                            return;
                        }
                        if (obj != null) {
                            list.add(obj);
                            savePath = successPath;
                            success += 1;
                        } else {
                            savePath = failPath;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        savePath = failPath;
                        fail += 1;
                    } finally {
                        if(savePath != null) {
                            FileChannel fc = new FileOutputStream(
                                savePath + File.separator + fileCount++ + "-" + f.getName())
                                    .getChannel();
                            new FileInputStream(f).getChannel().transferTo(0, f.length(), fc);
                        }
                    }
                }
            }

            //遍历显示所有文件
            for (JSONObject jsonObject : list) {
                System.out.println(jsonObject);
                System.out.println(
                    String.format("\"---------------------------%s------------------------\"",
                        jsonObject.get("fileName")));
                StringBuffer head = new StringBuffer();
                StringBuffer content = new StringBuffer();
                JSONArray datas = jsonObject.getJSONArray("data");
                //遍历文件中的所有行
                for (int i = 0; i < datas.size(); i++) {
                    JSONObject data = datas.getJSONObject(i);
                    //遍历所有列
                    Iterator<Entry<String, Object>> iter = data.entrySet().iterator();
                    //Formatter formatter = new Formatter();
                    while (iter.hasNext()) {
                        Entry<String, Object> item = iter.next();
                        String value = (String) item.getValue();
                        value = (value != null)
                            ? (value.length() > 17) ? value.substring(0, 17) + "..." : value
                            : "";
                        String key = (String) item.getKey();
                        key = (key != null)
                            ? (key.length() > 17) ? key.substring(0, 17) + "..." : key
                            : "";
                        
                        if (i == 0) {
                            head.append(String.format("%1$20s", key));
                        }else {
                            content.append(String.format("%1$20s", value));
                        }
                    } //end while
                    content.append("\n");
                } //遍历文件中的所有行 end
                System.out.println("--header--" + head.toString() + "--header--");
                System.out.println(content.toString());
                head.setLength(0);
                content.setLength(0);
            }
            System.out.println("success is " + success + ",fail is " + fail);
        }
    }

    public static JSONObject parseSingleDocx(File f, String firstTitleName) {

        try (FileInputStream in = new FileInputStream(f);
                XWPFDocument xwpf = new XWPFDocument(in);) {
            Iterator<XWPFTable> it = xwpf.getTablesIterator();//得到word中的表格 
            if (it.hasNext()) {
                XWPFTable table = it.next();
                List<XWPFTableRow> rows = table.getRows();
                if (rows == null || rows.size() <= 0) {
                    return null;
                }

                int rowNum = 0;
                String[] titles = null;
                //表头获取
                for (; rowNum < rows.size(); rowNum++) {
                    List<XWPFTableCell> titleCells = rows.get(rowNum).getTableCells();
                    String title = titleCells.get(0).getText();
                    if (!firstTitleName.equals(title)) {
                        continue;
                    }
                    titles = new String[titleCells.size()];//表头
                    titles[0] = title;
                    for (int i = 1; i < titleCells.size(); i++) {
                        titles[i] = titleCells.get(i).getText();
                    }
                    break;
                }

                //读取每一行数据  
                JSONArray datas = new JSONArray();
                for (; rowNum < rows.size(); rowNum++) {
                    XWPFTableRow row = rows.get(rowNum);
                    //读取每一列数据  
                    List<XWPFTableCell> cells = row.getTableCells();
                    JSONObject rowData = new JSONObject();
                    for (int j = 0; j < cells.size(); j++) {
                        XWPFTableCell cell = cells.get(j);
                        rowData.put(titles[j], cell.getText());
                        //System.out.println(cell.getText());
                    }
                    datas.add(rowData);
                }
                JSONObject result = new JSONObject();
                result.put("fileName", f.getName());
                result.put("head", titles);
                result.put("data", datas);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("resource")
    public static JSONObject parseSingleDoc(File f, String firstTitleName) {
        try (FileInputStream in = new FileInputStream(f); //载入文档  
                POIFSFileSystem pfs = new POIFSFileSystem(in);
                ) {
            HWPFDocument hwpf = new HWPFDocument(pfs);
            Range range = hwpf.getRange();//得到文档的读取范围  
            TableIterator it = new TableIterator(range);
            //迭代文档中的表格  
            while (it.hasNext()) {
                Table tb = (Table) it.next();

                if (tb.numRows() <= 0) {
                    return null;
                }

                //表头获取
                String[] titles = null;//表头
                int column = 0;
                for (; column < tb.numRows(); column++) {
                    TableRow titleTr = tb.getRow(column);
                    String title = getCellContent(titleTr.getCell(0));
                    if (!firstTitleName.equals(title)) {
                        continue;
                    }
                    titles = new String[titleTr.numCells()];
                    titles[0] = title;
                    for (int j = 1; j < titleTr.numCells(); j++) {
                        title = getCellContent(titleTr.getCell(j));
                        titles[j] = title;
                    }
                    break;
                }

                //迭代行，默认从0开始
                JSONArray datas = new JSONArray();
                for (; column < tb.numRows(); column++) {
                    TableRow tr = tb.getRow(column);
                    JSONObject rowData = new JSONObject();
                    //迭代列，默认从0开始  
                    for (int j = 0; j < tr.numCells(); j++) {
                        TableCell td = tr.getCell(j);//取得单元格  
                        //取得单元格的内容  
                        rowData.put(titles[j], getCellContent(td));
                    } //end for iterator cells
                    datas.add(rowData);
                } //end for iterator rows

                JSONObject result = new JSONObject();
                result.put("fileName", f.getName());
                result.put("head", titles);
                result.put("data", datas);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getCellContent(TableCell td) {
        StringBuffer ret = new StringBuffer();
        for (int k = 0; k < td.numParagraphs(); k++) {
            Paragraph para = td.getParagraph(k);
            byte[] bts = para.text().getBytes();
            ret.append(new String(bts, 0, bts.length - 1));
            //System.out.println(File2HexPrintUtil.byte2HexStr(bts, 0, bts.length));
            //System.out.println(new String(bts, 0, bts.length - 1));
        } //end for 
        return ret.toString();

    }

    public static void main(String[] args) throws IOException {
        String filePath = "D:\\文件下载\\word\\word\\";
        String failPath = "D:\\文件下载\\word\\fail\\";
        String successPath = "D:\\文件下载\\word\\success\\";
        String firstTitleName = "序号";
        ParseWordUtil.parseWords(filePath, successPath, failPath, firstTitleName,DocType.DOC);

    }
}
