package com.example.demo;

import javafx.beans.property.SimpleDoubleProperty;


public class Data {
    private SimpleDoubleProperty weight = new SimpleDoubleProperty(0.0);
    private String date;


    public Data(double weight, String date) {
        setWeight(weight);
        this.date = date;
    }

    public double getWeight() {
        return weight.get();
    }

    public SimpleDoubleProperty weightProperty() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}