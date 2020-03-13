package com.company;

import java.util.*;

/**
 * Survival knapsack with certain capacity, equip it optimally with food, weapons and books and win the new ??? Battle Royale.
 */
public class Knapsack {
    private double capacity;
    private List<Item> items = new LinkedList<>();

    Knapsack() {
    }

    Knapsack(double capacity) {
        this.capacity = capacity;
    }

    Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
        for(Item item: items) {
            this.capacity -= item.getWeight();
        }
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public void setItems(List<Item> items) {
        this.items = items;
        for(Item item: items) {
            this.capacity -= item.getWeight();
        }
    }

    public void addItem(Item item) {
        items.add(item);
        this.capacity -= item.getWeight();
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        Collections.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        double value = 0;
        for(Item item:items){
            value +=item.getValue();
        }
        return "Knapsack{" +
                "value=" + value +
                ", capacity=" + capacity +
                ", items=" + items +
                '}';
    }
}
