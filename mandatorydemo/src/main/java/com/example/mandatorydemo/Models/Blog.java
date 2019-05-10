package com.example.mandatorydemo.Models;

public class Blog {

    private int bid;
    private String blogpost_name;
    private String blogpost;
    private String date;

    public Blog() {
    }

    public Blog(int bid, String blogpost_name, String blogpost, String date) {
        this.bid = bid;
        this.blogpost_name = blogpost_name;
        this.blogpost = blogpost;
        this.date = date;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBlogpost_name() {
        return blogpost_name;
    }

    public void setBlogpost_name(String blogpost_name) {
        this.blogpost_name = blogpost_name;
    }

    public String getBlogpost() {
        return blogpost;
    }

    public void setBlogpost(String blogpost) {
        this.blogpost = blogpost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
