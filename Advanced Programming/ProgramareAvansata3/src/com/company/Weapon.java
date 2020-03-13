package com.company;

/**
 * Various weaponry, both medieval(ex: sword) and modern(ex: SMG).
 * Each weapon is named after its type.
 */
public class Weapon implements Item {

    private WeaponType type;
    private double weight;
    private double value;

    Weapon() {
    }

    /**
     * Create an weapon by using the following parameters:
     *
     * @param type
     * @param weight
     * @param value
     */
    Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Change the weapon's type(also changes its name)
     *
     * @param type
     */
    public void setType(WeaponType type) {
        this.type = type;
    }

    /**
     * Change the weapon's weight
     *
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Change the weapon's value
     *
     * @param value
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public String getName() {
        return type.name();
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "name=" + type +
                ", weight=" + weight +
                ", value=" + value +
                '}';
    }
}
