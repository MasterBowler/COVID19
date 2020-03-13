package com.company;

/**
 * Various crafting/survival books
 */
public class Book implements Item {
    private String name;
    private int pageNumber; //→ getWeight
    private double value;

    Book() {
    }

    Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the book's number of pages, also affects its weight ( weight = pages/100)
     *
     * @param pageNumber
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double getWeight() {
        return pageNumber / 100;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", weight=" + getWeight() +
                ", value=" + value +
                '}';
    }
}
