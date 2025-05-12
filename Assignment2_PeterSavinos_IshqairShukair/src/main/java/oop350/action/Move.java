package oop350.action;

import oop350.model.*;

/**
 * Represents an action where the player attempts to move through a door.
 * Only allowed if the door is unguarded (no monster).
 */
public final class Move implements Action {
    private final Dungeon dungeon; // reference to the game state
    private final Door door;       // the door the player wants to move through

    /**
     * Constructs a Move action for a given door and dungeon context.
     * @param dungeon the dungeon that manages current chamber state
     * @param door the door the player is trying to go through
     */
    public Move(Dungeon dungeon, Door door){
        this.dungeon = dungeon;
        this.door = door;
    }

    /**
     * Returns a description of the action for display in the action menu.
     */
    @Override
    public String description() {
        return "Move through door";
    }

    /**
     * Executes the move:
     * - If the door is guarded by a monster, prints a warning and cancels the move.
     * - If unguarded, moves the player to the chamber on the other side of the door.
     */
    @Override
    public void execute() {
        // Block movement if a monster is guarding the door
        if (door.getGuard() != null) {
            System.out.println("A " + door.getGuard() + " blocks the way!");
            return;
        }

        // Move to the connected chamber
        dungeon.setCurrentChamber(door.other(dungeon.getCurrentChamber()));
        System.out.println("You move into the next chamber.");
    }
}
