import javax.swing.plaf.TextUI;
import java.util.concurrent.ConcurrentHashMap;

/**
 * The Game class is a start point to the dungeon game
 * It initalizes the playspace with chambers, doors, monsters, and items.
 * The game is started officially through a text-based UI.
 */
public class Game {
    /**
     * Main method that initializes and starts the game.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Chamber[] chambers = new Chamber[]{
                new Chamber(), // chamber 1 is empty
                new Chamber(new Axe()), // chamber 2 has an axe item
                new Chamber(new Shield()), // chamber 3 has a shield item
                new Chamber(), // chamber 4 is empty
                new Chamber() // chamber 5 is empty

        };
        // doors that connect the chambers
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Goblin",1,0,3)); // door 2 is guarded by a goblin
        Door.connect(chambers[2], chambers[3], new Monster("Spider",3,0,5)); // door 3 is guarded by a spider
        Door.connect(chambers[3], chambers[4]);

        Character player = new Wizard ("Gandalf"); // playable character is created as a wizard named Gandalf

        Dungeon d = new Dungeon(player, chambers[0], chambers[4]); // create a dungeon with the player, starting chamber, and goal chamber
        new TextUI().play(d); // starts the game
    }
}
