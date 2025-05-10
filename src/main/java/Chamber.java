

import java.util.*;

/**
 * The Chamber class serves as a room or playspace for the game that contains the doors and items.
 * There are methods to make modifications to the items and doors of the chamber.
 */
public final class Chamber {
    private final List<Item> items = new ArrayList<>(); // List to store items that are in the Chamber
    private final List<Door> doors = new ArrayList<>(); // List to store doors that connect the Chamber

    /**
     * Constructor for the Chamber initalizing items.
     * @param initial An array of Item objects that can be initialized to the Chamber
     */
    public Chamber(Item... initial) {
        if (initial != null) {
            items.addAll(Arrays.asList(initial)); // adds the initialized items to the chamber
        }
    }

    /**
     * Adds doors to the Chamber.
     * @param d the door that is added
     */
    void addDoor (Door d) { doors.add(d);}

    /**
     * Method that returns a list of the objects that are Doors in the Chamber.
     * @return A list of objects (Door)
     */
    public List<Door> getDoors() { return doors;}

    /**
     * Method that returns a list of the objects that are items in the Chamber.
     * @return A list of objects (Item)
     */
    public List<Item> getItems() { return items;}
}
