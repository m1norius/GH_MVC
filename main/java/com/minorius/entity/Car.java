package com.minorius.entity;

/**
 * Created by minorius on 18.04.2017.
 */
public class Car {

    private String mark;
    private String model;
    private int year;
    private int maxSpeed;
    private int weight;

    public Car(String mark, String model, int year, int maxSpeed, int weight) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.maxSpeed = maxSpeed;
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
