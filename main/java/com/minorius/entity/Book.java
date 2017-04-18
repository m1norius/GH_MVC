package com.minorius.entity;

import java.time.LocalDateTime;

public class Book {

    private String name;
    private String message;
    private int value;
    private LocalDateTime time;

    public String getName() {
        return name;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
