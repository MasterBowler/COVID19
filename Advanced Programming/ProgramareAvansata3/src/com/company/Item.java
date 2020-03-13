package com.company;

/**
 * Common interface for weapons, books and foods.
 */
public interface Item {
    String getName();

    double getValue();

    double getWeight();

    default double profitFactor() {
        return getValue() / getWeight();
    }
}
