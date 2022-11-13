package com.example.newsio;

import java.util.ArrayList;

public class NewsMain {

        private String status;
        private String totalResults;
        private ArrayList<InitilizationsMod> articles;

    public NewsMain(String status, String totalResults, ArrayList<InitilizationsMod> articles) {
        this.status = status;
        this.totalResults = totalResults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<InitilizationsMod> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<InitilizationsMod> articles) {
        this.articles = articles;
    }
}
