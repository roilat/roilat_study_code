package cn.roilat.framework.common.result;

import java.util.List;

public class CommonPageResult<T> extends BaseResult {
    /**  */
    private static final long serialVersionUID = 3036522358277115355L;
    private List<T> data;
    /**
     * 总条数
     */
    private long    totalCounts = 0;

    /**
     * 总页数
     */
    private int     totalPages  = 0;

    /**
     * 当前页码
     */
    private int     currentPage = 0;

    /**
     * 每页条数
     */
    private int     pageSize    = 0;

    /**
     * 填充分页信息
     *
     * @param totalCounts 总条数
     * @param currentPage 当前页数
     * @param pageSize    每页大小，需要为整数
     */
    public void fillPageInfo(long totalCounts, int currentPage, int pageSize) {
        setTotalCounts(totalCounts);
        setTotalPages((int) (totalCounts + pageSize - 1) / pageSize);
        setCurrentPage(currentPage);
        setPageSize(pageSize);
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(long totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "CommonPageResult [data=" + data + ", totalCounts=" + totalCounts + ", totalPages="
               + totalPages + ", currentPage=" + currentPage + ", pageSize=" + pageSize + ", msg="
               + msg + ", success=" + success + "]";
    }
    
}
