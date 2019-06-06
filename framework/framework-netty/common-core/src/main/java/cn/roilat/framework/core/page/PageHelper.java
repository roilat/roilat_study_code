package cn.roilat.framework.core.page;

import java.io.Serializable;
import java.util.List;

public class PageHelper<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	//每页显示多少条
	private Integer pageSize;  
	//当前页数
	private Integer currentPage;
	//数据起始位置
	private Integer startIndex;
	
	private List<T> list;
	
	private T queryObj;
	
	private int total;
	
	private int totals;
	
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public T getQueryObj() {
		return queryObj;
	}
	public void setQueryObj(T queryObj) {
		this.queryObj = queryObj;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getTotals() {
		return totals;
	}
	public void setTotals(int totals) {
		this.totals = totals;
	}
}
