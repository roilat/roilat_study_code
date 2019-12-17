package cn.roilat.framework.core.dto;

import java.io.Serializable;

public class PageHelper implements Serializable {
	private static final long serialVersionUID = 4768891699790022461L;
	public static final int DEFAULT_PAGESIZE = 10;
	public static final int DEFAULT_CURRENTPAGE = 1;
	// 每页显示多少条
	private Integer pageSize = DEFAULT_PAGESIZE;
	// 当前页数
	private Integer currentPage = DEFAULT_CURRENTPAGE;
	// 数据起始位置
	private Integer startIndex;

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
}
