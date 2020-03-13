package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Knapsack knapsack = new Knapsack(10);
        Book book1 = new Book("Dragon Rising", 300, 5);
        Book book2 = new Book("A Blade in the Dark", 300, 5);
        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 2);
        Weapon weapon = new Weapon(WeaponType.Sword, 5, 10);
        knapsack.addItem(weapon);
        knapsack.addItem(book1);
        knapsack.addItem(food1);
        System.out.println(knapsack);

        double capacity = 10;
        //read capacity
        Knapsack knapsack1 = new Knapsack(capacity);
        List<Item> items = new LinkedList<>();
        //read items
        items.add(book1);
        items.add(book2);
        items.add(food1);
        items.add(food2);
        items.add(weapon);
        Greedy greedy = new Greedy(knapsack1,items);
        greedy.computeSolution();
        System.out.println(knapsack1);

        Knapsack knapsack2 = new Knapsack(capacity);
        DynamicProgramming dynamicProgramming = new DynamicProgramming(knapsack2,items);
        dynamicProgramming.computeSolution();
        System.out.println(knapsack2);

        Knapsack testKnapsack = new Knapsack();
        List<Item> testList = new LinkedList<>();
        ProblemGenerator problemGenerator = new ProblemGenerator(30,20);
        problemGenerator.generateProblem(testKnapsack,testList);

        long startTime = System.nanoTime();
        DynamicProgramming dynamicProgramming1 = new DynamicProgramming(testKnapsack,testList);
        dynamicProgramming1.computeSolution();
        long duration = System.nanoTime() - startTime;
        System.out.println(testKnapsack);
        System.out.println(duration/1000);

        //reset
        testKnapsack.setCapacity(30);
        testKnapsack.getItems().clear();;

        startTime = System.nanoTime();
        Greedy greedy1 = new Greedy(testKnapsack,testList);
        greedy1.computeSolution();
        duration = System.nanoTime() - startTime;
        System.out.println(testKnapsack);
        System.out.println(duration/1000);

    }
}
