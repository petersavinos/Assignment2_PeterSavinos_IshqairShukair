package oop350.action;

import oop350.model.Character;
import oop350.model.Item;
import oop350.model.Chamber;

/**
 * Represents an action where the player picks up an item from a chamber.
 * The item is removed from the chamber and added to the player's inventory.
 */
public final class Pick implements Action {
    private final Character player;   // The character performing the action
    private final Item item;          // The item to pick up
    private final Chamber chamber;    // The chamber where the item currently is

    /**
     * Constructs a Pick action for a specific player, item, and chamber.
     * @param player the character picking up the item
     * @param item the item being picked up
     * @param chamber the chamber containing the item
     */
    public Pick(Character player, Item item, Chamber chamber) {
        this.player = player;
        this.item = item;
        this.chamber = chamber;
    }

    /**
     * Returns a description of the action to be displayed in the action menu.
     */
    @Override
    public String description() {
        return "Pick up " + item;
    }

    /**
     * Executes the pick-up:
     * - Removes the item from the current chamber
     * - Adds the item to the player's inventory
     * - Prints a confirmation message
     */
    @Override
    public void execute() {
        chamber.getItems().remove(item);   // Remove item from the room
        player.addItem(item);              // Add item to inventory
        System.out.println("You picked up " + item);  // Feedback
    }
}
