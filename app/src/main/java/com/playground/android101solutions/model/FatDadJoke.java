package com.playground.android101solutions.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created on 07/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class FatDadJoke {
    @SerializedName("current_page")
    private int currentPage;
    @SerializedName("next_page")
    private int nextPage;
    @SerializedName("previous_page")
    private int previousPage;
    @SerializedName("results")
    private List<DadJoke> jokes;
    private int status;

    public FatDadJoke(int currentPage, int nextPage, int previousPage, List<DadJoke> jokes, int status) {
        this.currentPage = currentPage;
        this.nextPage = nextPage;
        this.previousPage = previousPage;
        this.jokes = jokes;
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    public List<DadJoke> getJokes() {
        return jokes;
    }

    public void setJokes(List<DadJoke> jokes) {
        this.jokes = jokes;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
