package cn.roilat.framework.utils;


import java.util.List;
import java.util.Map;

public class ExcelConfig<T>{
	
	private String fileName;
	
	private String sheetName;
	
	private String title;
	
	private Map<String,String> header;

	private List<T> listData;
	
	private boolean showColumnCode = false;
	
	//注意事项   如果设置将在第一行显示相关信息
	private String attention;
	
	public ExcelConfig(){}
	
	public ExcelConfig(String fileName,String sheetName,String title,Map<String,String> header,List<T> listData){
		this.fileName = fileName;
		this.sheetName = sheetName;
		this.title = title;
		this.header = header;
		this.listData = listData;
	}
	
	public ExcelConfig(String fileName,String sheetName,String title,Map<String,String> header,List<T> listData,String attention){
		this(fileName,sheetName,title,header,listData);
		this.attention = attention;
	}

	public ExcelConfig(String fileName,String sheetName,String title,Map<String,String> header,boolean showColumnCode,List<T> listData,String attention){
		this(fileName,sheetName,title,header,listData,attention);
		this.showColumnCode = showColumnCode;
	}
	
	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public boolean getShowColumnCode() {
		return showColumnCode;
	}

	public void setShowColumnCode(boolean showColumnCode) {
		this.showColumnCode = showColumnCode;
	}
	
	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, String> getHeader() {
		return header;
	}

	public void setHeader(Map<String, String> header) {
		this.header = header;
	}
}
