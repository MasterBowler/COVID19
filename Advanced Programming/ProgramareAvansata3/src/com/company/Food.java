package com.company;

/**
 * Any food you wish for.
 */
public class Food implements Item {
    private String name;
    private double weight;

    Food() {
        this.name = "";
    }

    Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the weight of the food, also affect its value ( value = 2*weight)
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getValue() {
        return 2 * weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", value=" + getValue() +
                '}';
    }
}
