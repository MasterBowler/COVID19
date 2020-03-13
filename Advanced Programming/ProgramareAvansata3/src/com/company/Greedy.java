package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Greedy implements Algorithm {

    private Knapsack knapsack;
    private List<Item> availableItems;

    public Greedy(Knapsack knapsack, List<Item> availableItems) {
        this.knapsack = knapsack;
        this.availableItems = availableItems;
    }

    @Override
    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    @Override
    public void setAvailableItems(LinkedList<Item> items) {
        this.availableItems = items;
    }

    @Override
    public void computeSolution() {
        //sortez toate itemele in functie de profitFactor descrescator
        Collections.sort(availableItems, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if (o1.profitFactor() == o2.profitFactor())
                    return 0;
                else if (o1.profitFactor() < o2.profitFactor())
                    return 1;
                else return -1;
            }
        });
        //adaug iteme in rucsac cat timp nu am depasit capacitatea
        //clasa knapsack updateaza automat capacitatea ramasa dupa adaugarea unui item
        for (Item item : availableItems) {
            if (item.getWeight() <= knapsack.getCapacity()) {
                knapsack.addItem(item);
            }
        }
    }
}
