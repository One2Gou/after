package com.go.after.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 分页的工具类
 *
 * @author Dong
 */
public class PageBean {

    /**
     * 页码
     */
    private int page = 1;

    /**
     * 页大小
     */
    private int rows = 3;

    /**
     * 总记录行
     */
    private int total;

    /**
     * 是否分页
     */
    private boolean pagination = true;

    /**
     * 上一页请求的路径 项目名+请求路径
     */
    private String url;

    /**
     * 存储的参数
     */
    private Map<String, String[]> parametermap;

    public PageBean() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPage(String page) {
        //如果需要翻页
        if (page != null && !"".equals(page.trim())) {
            this.page = Integer.parseInt(page);
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setRows(String rows) {
        //如果需要设置页大小
        if (rows != null && !"".equals(rows.trim())) {
            this.rows = Integer.parseInt(rows);
        }
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal(long total) {
        this.total = (int) total;
    }

    public void setTotal(String total) {
        this.total = Integer.parseInt(total);
    }

    public boolean isPagination() {
        return pagination;
    }

    public void setPagination(boolean pagination) {
        this.pagination = pagination;
    }

    public void setPagination(String pagination) {
        //如果需要分页
        if (pagination != null && !"".equals(pagination.trim())) {
            this.pagination = Boolean.parseBoolean(pagination);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String[]> getParametermap() {
        return parametermap;
    }

    public void setParametermap(Map<String, String[]> parametermap) {
        this.parametermap = parametermap;
    }

    /**
     * setRequest方法用于重新发送请求
     */
    public void setRequest(HttpServletRequest request) {
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String pagination = request.getParameter("pagination");
        this.setPage(page);
        this.setRows(rows);
        this.setPagination(pagination);
        /* 获取请求的url:项目名+请求路径 */
        this.url = request.getContextPath() + request.getServletPath();

        // 获取请求的传来的参数
        this.parametermap = request.getParameterMap();

    }

    /**
     * 下一页的页码
     *
     * @return
     */
    public int getNextPage() {
        int nextPage = this.getPage() + 1;
        //下一页的页码大于最大页码
        if (nextPage > this.getMax()) {
            nextPage = this.getMax();
        }
        return nextPage;
    }

    /**
     * 最大页码
     */
    public int getMax() {
        int max = this.getTotal() / this.getRows();
        if (this.getTotal() % this.getRows() != 0) {
            max++;
        }
        return max;
    }

    /**
     * 上一页的页码
     *
     * @return
     */
    public int getPreviousPage() {
        int previous = this.getPage() - 1;
        //如果上一页的页码小于1
        if (previous < 1) {
            previous = 1;
        }
        return previous;
    }

    /**
     * 起始页码
     *
     * @return
     */
    public int getStart() {
        return (this.getPage() - 1) * this.getRows();
    }

    @Override
    public String toString() {
        return "PageBean [page=" + page + ", rows=" + rows + ", total=" + total + ", pagination=" + pagination + "]";
    }

}
