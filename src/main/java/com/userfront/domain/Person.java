package com.userfront.domain;

public class Person {

    private int alter;
    private String name;

    public Person(int alter, String name) {
        this.alter = alter;
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public String getName() {
        return name;
    }
}
