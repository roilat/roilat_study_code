package cn.roilat.framework.core.dto;

import java.io.Serializable;
import java.util.List;

import com.google.common.collect.Lists;

public class DataDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private List<?> datas = Lists.newArrayList();
	
	private int pageSize;
	
	private int currentPage;
	
	private int totals;

	public int getTotals() {
		return totals;
	}

	public void setTotals(int totals) {
		this.totals = totals;
	}

	private DataDTO(){
		
	}
	
	private DataDTO(List<?> datas, int currentPage,int totals) {
		this.datas = datas;
		this.currentPage = currentPage;
		this.totals = totals;
	}
	
	private DataDTO(List<?> datas,int pageSize, int currentPage,int totals) {
		this(datas,currentPage,totals);
		this.pageSize = pageSize;
	}

	public List<?> getDatas() {
		return datas;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public static DataDTO getInstance(List<?> datas, int currentPage,int totals){
		return new DataDTO(datas,currentPage,totals);
	}
	
	public static DataDTO getInstance(List<?> datas,int pageSize, int currentPage,int totals){
		return new DataDTO(datas,pageSize,currentPage,totals);
	}
	
}
