package com.company;

public class Hospital implements Comparable<Hospital>{
    //int capacity;
    String id;

    public Hospital(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int compareTo(Hospital o) {
        return this.id.compareTo(o.id);
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "id='" + id + '\'' +
                '}';
    }
}
