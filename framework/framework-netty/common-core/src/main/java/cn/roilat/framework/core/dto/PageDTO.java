package cn.roilat.framework.core.dto;

import java.io.Serializable;
import java.util.List;

public class PageDTO<T> implements Serializable {
	private static final long serialVersionUID = -6310850942667863132L;
	//每页显示多少条
	private int pageSize;  
	//当前页数
	private int currentPage;
	//总记录数
	private int totals;
	//分页数据
	private List<T> list;
	
	public PageDTO(int currentPage, int pageSize, int totals){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totals = totals;
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
	public int getTotals() {
		return totals;
	}
	public void setTotals(int totals) {
		this.totals = totals;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
