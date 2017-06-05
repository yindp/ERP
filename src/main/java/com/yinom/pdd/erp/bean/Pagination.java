package com.yinom.pdd.erp.bean;

/**
 * Created by yindp on 5/27/17.
 */
public class Pagination {
    private int totalPages;
    private int currentPage;
    private int rowsPerPage;
    private int totalRows;

    public Pagination() {

    }

    public Pagination(int totalPages, int currentPage, int rowsPerPage, int totalRows) {
        this.totalPages = totalPages;
        this.currentPage = currentPage;
        this.rowsPerPage = rowsPerPage;
        this.totalRows = totalRows;
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

    public int getRowsPerPage() {
        return rowsPerPage;
    }

    public void setRowsPerPage(int rowsPerPage) {
        this.rowsPerPage = rowsPerPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }
}
