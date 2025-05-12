package oop350.model;

import oop350.action.*;
import java.util.*;

/**
 * The Dungeon class manages the game state:
 * - Tracks the player
 * - Tracks the current and goal chambers
 * - Generates available actions each turn
 */
public final class Dungeon {
    // The player character currently navigating the dungeon
    private final Character player;

    // The chamber that represents the goal or exit
    private final Chamber goal;

    // The chamber the player is currently in
    private Chamber current;

    /**
     * Constructs a new dungeon.
     * @param player The player character
     * @param entry The starting chamber
     * @param goal The final goal chamber
     */
    public Dungeon(Character player, Chamber entry, Chamber goal) {
        this.player = player;
        this.current = entry;
        this.goal = goal;
    }

    /**
     * Gets the chamber the player is currently in.
     * @return the current chamber
     */
    public Chamber getCurrentChamber() {
        return current;
    }

    /**
     * Updates the player's current chamber.
     * Used when moving through a door.
     * @param c the new chamber to set
     */
    public void setCurrentChamber(Chamber c) {
        this.current = c;
    }

    /**
     * Checks if the game is over.
     * The game ends if the player reaches the goal or dies.
     * @return true if game is finished
     */
    public boolean isFinished() {
        return current == goal || player.isDead();
    }

    /**
     * Generates the list of possible actions for the player:
     * - Fight: if a monster guards a door
     * - Move: if the door is unguarded
     * - Pick: if items are present in the current chamber
     * @return list of available actions
     */
    public List<Action> getActions() {
        List<Action> acts = new ArrayList<>();

        // Add fight or move actions for each door
        for (Door d : current.getDoors()) {
            if (d.getGuard() != null) {
                acts.add(new Fight(player, d));
            } else {
                acts.add(new Move(this, d));
            }
        }

        // Add pickup actions for each item in the room
        for (Item i : current.getItems()) {
            acts.add(new Pick(player, i, current));
        }

        return acts;
    }
}
