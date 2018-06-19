package com.mama.baike.common.utils;

import com.github.pagehelper.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页工具类
 */
public class PageUtil<T> implements Serializable {

    private static final long serialVersionUID = 2674783657643188822L;

    private int current_page;
    private int from;
    private int last_page;
    private int pageLength;
    private int to;
    private long total;
    private List<T> data;


    private PageUtil() {
    }

    public PageUtil(PageInfo<T> pageInfo) {

        current_page = pageInfo.getPageNum();
        from = pageInfo.getStartRow();
        to = pageInfo.getEndRow();
        last_page = pageInfo.getPages();
        pageLength = pageInfo.getPageSize();
        total = pageInfo.getTotal();
        data = pageInfo.getList();
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getLast_page() {
        return last_page;
    }

    public void setLast_page(int last_page) {
        this.last_page = last_page;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageLength() {
        return pageLength;
    }

    public void setPageLength(int pageLength) {
        this.pageLength = pageLength;
    }
}
