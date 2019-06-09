package com.yx1030.springbootshiro.utils;

import java.util.List;

public class PageResult {
    //获取总数
    private int total;
    //获取list集合
    private List<?> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
