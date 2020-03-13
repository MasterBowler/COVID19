package com.company;

import java.util.List;
import java.util.Random;

public class ProblemGenerator {

    private int capacity;
    private int noOfItems;

    ProblemGenerator(int capacity, int noOfItems) {
        this.capacity = capacity;
        this.noOfItems = noOfItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public void generateProblem(Knapsack knapsack, List<Item> items) {
        knapsack.setCapacity(this.capacity);
        items.clear();
        knapsack.getItems().clear();
        int itemType;
        for (int i = 0; i < noOfItems; ++i) {
            Random rand = new Random();
            itemType = rand.nextInt(3);
            if (itemType == 0) {
                items.add(new Book("book" + i, rand.nextInt(10000), rand.nextInt(100)));
            } else if (itemType == 1) {
                items.add(new Food("food" + i, rand.nextInt(100)));
            } else {
                items.add(new Weapon(WeaponType.getRandomWeapon(), rand.nextInt(100), rand.nextInt(100)));
            }
        }
    }
}
