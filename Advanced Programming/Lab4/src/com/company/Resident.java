package com.company;

import java.util.List;

public class Resident {
    private String id;
    //private List<Hospital> preferences;

    public Resident(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id='" + id + '\'' +
                '}';
    }
}
