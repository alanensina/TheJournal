package com.alanensina.cklchallenge.model;

public class Tags {

    private int id;
    private String label;

    public Tags(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public Tags() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
