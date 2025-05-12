package oop350.model;

/**
 * the Monster class serves as a representation of the guards that are blocking the doors throughout the dungeon.
 * Every Monster has a name, strength, craft, and health.
 */
public class Monster {
    private final String name; // name of the monster
    private int strength; // the strength and combat power of the monster
    private int craft; // the craft or special combat power of the monster
    private int health; // the health of the monster

    /**
     * Constructor that initializes the monster with its name, strength, craft, and health
     * @param name name of the monster
     * @param str strength of the monster
     * @param crf craft of the monster
     * @param hp health points of the monster
     */
    public Monster(String name, int str, int crf, int hp) {
        this.name = name;
        strength = str;
        craft = crf;
        health = hp;
    }

    /**
     * Methods that rolls a random number on a di to determine the combat attack
     * @return the number rolled on the dice
     */
    public int roll(){ return oop350.util.Dice.roll(); }
    /**
     * Method that reduces the amount of health of a monster given the damage
     * @param d the amount of damage taken
     */
    public void damage(int d) {
        health = Math.max(0,health-d);
    }

    /**
     * Method to check if the monster is dead
     * @return true if the monster is dead, false if not
     */
    public boolean dead() {
        return health <= 0;
    }

    /**
     * method to get the monster's strength level
     * @return strength of the monster
     */

    public int getStrength() {
        return strength;
    }

    /**
     * method to get the monster's craft level
     * @return craft of the monster
     */

    public int getCraft() {
        return craft;
    }

    /**
     * method to get the monster's health level
     * @return health of the monster
     */

    public int getHealth() {
        return health;
    }

    /**
     * method to return a string that describes the monster's stats.
     * @return a formatted string that includes the monster's name, health, strength, and craft.
     */

    @Override public String toString() {
        return String.format("%s (HP:%d STR:%d CRF:%d)", name, health, strength, craft);
    }
}
