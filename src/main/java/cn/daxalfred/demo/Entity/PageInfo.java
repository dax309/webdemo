package cn.daxalfred.demo.Entity;

import java.util.List;

public class PageInfo {
    //页面大小
    private int pageSize;
    //页数
    private int pageNumber;
    //总长度
    private long total;
    //每页列表
    private List<?> list;

    public PageInfo(int pageSize, int pageNumber, long total, List<?> list) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.total = total;
        this.list = list;
    }

    public PageInfo() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageSize=" + pageSize +
                ", pageNumber=" + pageNumber +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
