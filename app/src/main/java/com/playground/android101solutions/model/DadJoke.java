package com.playground.android101solutions.model;

/**
 * Created on 07/04/2021.
 *
 * @author Konstantin Vankov (xcg3679)
 */
public class DadJoke {
    private String id;
    private String joke;
    private int status;

    public DadJoke(String id, String joke, int status) {
        this.id = id;
        this.joke = joke;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
