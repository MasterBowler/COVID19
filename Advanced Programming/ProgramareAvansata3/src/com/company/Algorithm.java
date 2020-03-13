package com.company;

import java.util.LinkedList;

public interface Algorithm {
    void setKnapsack(Knapsack knapsack);

    void setAvailableItems(LinkedList<Item> items);

    void computeSolution();

    //Knapsack getSolution();
}
