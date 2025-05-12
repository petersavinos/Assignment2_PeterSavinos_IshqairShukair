import java.util.ArrayList;


/**
 * Dungeon class that manages the state of the game. It manages the loations of the player,
 * the chamber which is the goal, the actions and movements a player can make, and the items and doors.
 */
public final class Dungeon {

    private final Character player; // playable character
    private final Chamber goal; // the target and final destination which the player must reach
    private Chamber current; // the chamber that the player is currently in

    /**
     * Constructor that initializes the player, start chamber, and gaol chamber
     * @param player playable character
     * @param entry start chamber
     * @param goal final goal chamber
     */
    public Dungeon(Character player, Chamber entry, Chamber goal) {
        this.player = player;
        this.current = entry;
        this. goal = goal;
    }

    /**
     * Method to get the current chamber which the player is in
     * @return the current chamber
     */
    public Chamber getCurrentChamber() {
        return current;
    }

    /**
     * Method to set the current chamber as the player moves into new chambers
     * @param c the new current chamber
     */
    void setCurrentChamber(Chamber c) {
        current = c;
    }

    /**
     * Method to see if the dungeon is completed.
     * The player either reachs the goal chamber or the player died
     * @return true if dungeon is finished, false if not
     */
    public boolean isFinished() {
        return current == goal || player.isDead();
    }

    /**
     * Method that returns a list of the available actions a player can get from the current chamber they are in
     * The player can either fight a monster that guards a door,
     * Move through an unguarded door,
     * Pick up items from the current chamber.
     * @return A list of objects (Action) that the player can do
     */
    public List<Action> getActions(){
        List<Action> acts = new ArrayList<>();
        for (Door d : current.getDoors()) { // checks if the doors in current chamber are guarded
            if(d.getGuard() != null) { // if the door is guarded then the player can fight the monster
                acts.add(new Fight(player, d));
            } else {
                acts.add(new Move(this.d)); // otherwise the player can move through the door
            }
        }
        for (Item i : current.getItems()) {
            acts.add(new Pick(player, i, current)); // player can pick up items in the current chamber
        }
        return acts;
    }
}
