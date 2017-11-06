package com.gigaspaces.timestampcheck.common;

import com.gigaspaces.annotation.pojo.SpaceId;

public class Person {

    private Integer id;
    private String name;
    private Long lastUpdated;

    public Person() {}

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @SpaceId(autoGenerate=false)
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return "Person #" + id + ": " + name + " (" + lastUpdated.toString() + ")";
    }
}