package com.go.after.common.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Author dong
 */
public class PageUtils implements Serializable {
    private static final long serialVersionUID = 1L;
    private int total;
    private List<?> rows;

    public PageUtils(List<?> list, int total) {
        this.rows = list;
        this.total = total;
    }

    public PageUtils(List<?> list, Long total) {
        this.rows = list;
        this.total = total.intValue();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal(Long total) {
        this.total = total.intValue();
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
