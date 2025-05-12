package oop350.model;

import java.util.*;

/**
 * Abstract base class for all player characters (e.g., Warrior, Wizard).
 * Defines shared attributes and behaviors like stats, health, and inventory.
 */
public abstract class Character {
    // Basic character stats
    protected String name;
    protected int strength;
    protected int craft;
    protected int health;

    // Player's inventory and equipped items (max 2)
    private final List<Item> inventory = new ArrayList<>();
    private final Set<Item> inUse = new HashSet<>(2);

    /**
     * Constructor sets the player's base attributes.
     * @param name - player name
     * @param str - base strength
     * @param crf - base craft
     * @param hp - starting health
     */
    protected Character(String name, int str, int crf, int hp) {
        this.name = name;
        this.strength = str;
        this.craft = crf;
        this.health = hp;
    }

    /**
     * Calculates total strength (base + equipped item bonuses).
     * @return total strength
     */
    public int getStrengthTotal() {
        return strength + inUse.stream().mapToInt(Item::getStrength).sum();
    }

    /**
     * Calculates total craft (base + equipped item bonuses).
     * @return total craft
     */
    public int getCraftTotal() {
        return craft + inUse.stream().mapToInt(Item::getCraft).sum();
    }

    /**
     * Rolls a 1–6 sided die for use in combat.
     * @return a random int between 1 and 6
     */
    public int roll() {
        return oop350.util.Dice.roll();
    }

    /**
     * Reduces health by a given amount (but never below 0).
     * @param d - damage taken
     */
    public void damage(int d) {
        health = Math.max(0, health - d);
    }

    /**
     * Checks if the character has died (health is 0 or below).
     * @return true if dead
     */
    public boolean isDead() {
        return health <= 0;
    }



    /**
     * Adds an item to the player's inventory.
     * @param i - item to add
     */
    public void addItem(Item i) {
        inventory.add(i);
    }

    /**
     * Equips an item (max 2 at a time) if it's in the inventory.
     * @param i - item to equip
     */
    public void useItem(Item i) {
        if (inventory.contains(i) && inUse.size() < 2) {
            inUse.add(i);
        }
    }

    /**
     * Returns a list of items currently in inventory.
     * @return inventory list
     */
    public List<Item> getInventory() {
        return inventory;
    }
}
