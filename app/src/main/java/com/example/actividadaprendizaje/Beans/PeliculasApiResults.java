package com.example.actividadaprendizaje.Beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculasApiResults {

    private Integer page;
    private List<Peliculas> results;
    private Integer total_pages;
    private Integer total_results;

    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public List<Peliculas> getResults() {
        return results;
    }
    public void setResults(List<Peliculas> results) {
        this.results = results;
    }
    public Integer getTotal_pages() {
        return total_pages;
    }
    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }
    public Integer getTotal_results() {
        return total_results;
    }
    public void setTotal_results(Integer total_results) {
        this.total_results = total_results;
    }
}
