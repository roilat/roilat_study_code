package cn.roilat.framework.utils;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelOperationUtil {
	//private static final String EXCEL_XLS = "xls";  
    private static final String EXCEL_XLSX = "xlsx";
	private static ThreadLocal<Workbook> ThreadWorkbook = new ThreadLocal<Workbook>();
	
	private static Workbook getWorkbook(String fileName) throws Exception {
		File file = new File(fileName);
		return getWorkbook(file);
	}
	
	private static Workbook getWorkbook(File file) throws Exception {
		Workbook wb = null;
		if(FileUtil.existsFile(file)){
			FileInputStream in = new FileInputStream(file);
			if(file.getName().endsWith(EXCEL_XLSX)) {
				//2007版本及以上
				wb = new XSSFWorkbook(in);
	        } else {  
	        	//2003版本
	        	wb = new HSSFWorkbook(in);
	        }
		}else{
			if(file.getName().endsWith(EXCEL_XLSX)) {
				//2007版本及以上
				wb = new XSSFWorkbook();
	        } else {  
	        	//2003版本
	        	wb = new HSSFWorkbook();
	        }
		}
		ThreadWorkbook.set(wb);
		return wb;
	}
	
	private static Sheet createSheet(String sheetName) throws Exception{
		if(StringUtil.isNotEmpty(sheetName)){
			return ThreadWorkbook.get().createSheet(sheetName);
		}
		return ThreadWorkbook.get().createSheet();
	}
	
	private static void addCellStyle(Cell cell,int flag){
		CellStyle cellStyle = ThreadWorkbook.get().createCellStyle();
		cellStyle.setAlignment(CellStyle.ALIGN_CENTER);  //水平居中
		cellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER); //垂直居中
		cellStyle.setBorderBottom(CellStyle.BORDER_THIN); //下边框    
		cellStyle.setBorderLeft(CellStyle.BORDER_THIN);//左边框    
		cellStyle.setBorderTop(CellStyle.BORDER_THIN);//上边框    
		cellStyle.setBorderRight(CellStyle.BORDER_THIN);//右边框s
		cellStyle.setWrapText(false);
		Font font = ThreadWorkbook.get().createFont();
		if(flag == 1){
			font.setFontHeightInPoints((short) 18);
			font.setBoldweight((short) 700);
		}else if(flag == 2){
			font.setFontHeightInPoints((short) 14);
			font.setBoldweight((short) 700);
		}else if(flag == 3){
			font.setFontHeightInPoints((short) 12);
		}
		font.setFontName("仿宋_GB2312");
		cellStyle.setFont(font);
		cell.setCellStyle(cellStyle);
	}
	
	private static <T> void writeData(Sheet sheet,String title,Map<String,String> headersMap,boolean showColumnCode,List<T> listData,String attention){
		
		/*************
		 * 写入注意事项
		 */
		int rowIndex = 0;
		if(StringUtil.isNotEmpty(attention)){
			Cell cell = sheet.createRow(rowIndex).createCell(0);
			addCellStyle(cell,1);
			cell.setCellValue(attention);
			CellRangeAddress cellRangeAddressTitle = new CellRangeAddress(rowIndex, rowIndex, 0, headersMap.size()-1 );
            sheet.addMergedRegion(cellRangeAddressTitle);
			RegionUtil.setBorderBottom(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderLeft(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderRight(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderTop(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
		}
		
		
		/********
		 * 写入标题（始终从第二行开始写入，第一行留着写入注意事项） 即：rowIndex始终为1
		 */
		rowIndex = 1;
		if(StringUtil.isNotEmpty(title)){
			Cell cell = sheet.createRow(rowIndex).createCell(0);
			addCellStyle(cell,1);
			cell.setCellValue(title);
			CellRangeAddress cellRangeAddressTitle = new CellRangeAddress(rowIndex, rowIndex, 0, headersMap.size()-1 );
            sheet.addMergedRegion(cellRangeAddressTitle);
			RegionUtil.setBorderBottom(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderLeft(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderRight(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			RegionUtil.setBorderTop(1, cellRangeAddressTitle, sheet, ThreadWorkbook.get());
			rowIndex++;
		}
		
		
		/*******
		 * 写入头部
		 */
		//保存字段编码
		List<String> headersColumnCode = Lists.newArrayList();
		//保存字段名称
		List<String> headersColumnName = Lists.newArrayList();
		//headersMap----》key为字段编码   value为字段名称（例如：name-->姓名）
		if(headersMap != null && headersMap.size() > 0){
			headersMap.forEach((k,v) ->{
				headersColumnCode.add(k);
				headersColumnName.add(v);
			});
			if(showColumnCode){
				Row row = sheet.createRow(rowIndex);
				for(int i = 0; i < headersColumnCode.size(); i++){
					Cell headerCell = row.createCell(i);
					addCellStyle(headerCell,2);
					headerCell.setCellValue(headersColumnCode.get(i));
				}
				rowIndex++;
			}
			Row row = sheet.createRow(rowIndex);
			for(int i = 0; i < headersColumnName.size(); i++){
				Cell headerCell = row.createCell(i);
				addCellStyle(headerCell,2);
				headerCell.setCellValue(headersColumnName.get(i));
			}
			rowIndex++;
		}
		
		/********
		 * 写入body数据
		 */
		if(listData != null && listData.size() > 0){
			for(T data:listData){
				Row dataRow = sheet.createRow(rowIndex);
				for(int i = 0; i<headersColumnCode.size(); i++){
					Object value = ReflectUtil.getValueByField(headersColumnCode.get(i),data);
					if(value instanceof Date){
						value = DateUtil.defaultDateTimeFormat((Date)value);
					}
					Cell cell = dataRow.createCell(i);
					addCellStyle(cell,3);
					cell.setCellValue(StringUtil.nullToEmpty(String.valueOf(value)));
				}
				rowIndex++;
			}
		}
		
		/*********
		 * 设置列宽为自动列宽
		 */
		for(int i = 0; i < headersColumnCode.size(); i++){
			sheet.autoSizeColumn(i);
		}
	}
	
	/**********
	 * 注意    头部header定义的Map中的key值必须和传入对象listData实体中的属性名称保持一致，否则无法进行写入
	 * @param fileName   生成后的文件名称+路径  如：d:\\test.xlsx
	 * @param sheetName  
	 * @param title
	 * @param header
	 * @param listData
	 * @throws Exception
	 */
	public static <T> void writeData2Excel(ExcelConfig<T> config) throws Exception{
		Workbook workbook= getWorkbook(config.getFileName());
		Sheet sheet = createSheet(config.getSheetName());
		CellStyle style = workbook.createCellStyle();
		DataFormat  format = workbook.createDataFormat();
		style.setDataFormat(format.getFormat("@"));
		//循环设置列文本格式为文本
		for(int i = 0; i < config.getHeader().size(); i++){
			sheet.setDefaultColumnStyle(i, style);
		}
		writeData(sheet,config.getTitle(),config.getHeader(),config.getShowColumnCode(),config.getListData(),config.getAttention());
		OutputStream out = new FileOutputStream(new File(config.getFileName()));
		workbook.write(out);
		out.close();
	}
	
	public static List<Map<String,Object>> readData(File file) throws Exception {
		List<Map<String,Object>> datas = Lists.newArrayList();
		
		getWorkbook(file);
		//int sheetCount = workbook.getNumberOfSheets();
		Sheet sheet = ThreadWorkbook.get().getSheetAt(0);
		//总行数（从0开始计算，因此需要加1）
		int rowCount = sheet.getLastRowNum() + 1;
		//总列数
		int cellCount = sheet.getRow(1).getPhysicalNumberOfCells();
		
		//字段名称（数据库字段名称）始终在第三行
		Row fieldRow = sheet.getRow(2);
		//保存字段
		List<String> fieldsName = Lists.newArrayList();
		for(int j = 0; j < cellCount; j++){
			Cell cell = fieldRow.getCell(j);
			fieldsName.add(cell.getStringCellValue());
		}
		//真是数据从第4行开始
		for(int i = 4; i < rowCount; i++){
			Row row = sheet.getRow(i);
			if(row == null)continue;
			Map<String,Object> data = Maps.newHashMap();
			for(int j = 0; j < cellCount; j++){
				Cell cell = row.getCell(j);
				if(cell == null){
					data.put(fieldsName.get(j), "");
				}else{
					switch(cell.getCellType()){
						case Cell.CELL_TYPE_BLANK:
							data.put(fieldsName.get(j),"");
							break;
						case Cell.CELL_TYPE_NUMERIC:
							data.put(fieldsName.get(j),String.valueOf(cell.getNumericCellValue()));
							break;
						default:
							data.put(fieldsName.get(j),cell.getStringCellValue());
					}
					
				}
			}
			datas.add(data);
		}
		System.out.println(datas);
		return datas;
	}
	
	public static void main(String[] args) throws Exception{
		/*String fileName = "c:\\测试.xlsx";
		File file = new File(fileName);
		readData(file);*/
		Map<String,String> header= new LinkedHashMap<String,String>();
		header.put("name","姓名");
		header.put("age","编号");
		header.put("birthday","生日");
		DemoUser user1 = new DemoUser("刘杰",30,new Date());
		DemoUser user2 = new DemoUser("下雨",31,new Date());
		DemoUser user3 = new DemoUser("唐丽",28,new Date());
		List<DemoUser> listData = Lists.newArrayList(user1,user2,user3);
		String fileName = "c:\\测试.xlsx";
		String sheetName = "test表单";
		String title = "报表";
		String attention = "日期格式：yyyy-MM-dd HH:mm:ss";
		ExcelConfig<DemoUser> config = new ExcelConfig<DemoUser>(fileName,sheetName,title,header,true,listData,attention);
		writeData2Excel(config);
		
		
	}
}