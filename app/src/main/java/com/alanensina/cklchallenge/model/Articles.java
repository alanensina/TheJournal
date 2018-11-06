package com.alanensina.cklchallenge.model;

import java.util.List;

public class Articles {

    private String title, website, authors, date, content, img_url;
    private List<Tags> tags;

    public Articles() {
    }

    public Articles(String title, String website, String authors, String date, String content, String img_url, List<Tags> tags) {
        this.title = title;
        this.website = website;
        this.authors = authors;
        this.date = date;
        this.content = content;
        this.img_url = img_url;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }
}