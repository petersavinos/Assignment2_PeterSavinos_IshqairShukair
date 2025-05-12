/**
 * The Door class serves as a connector between two Chambers.
 * The Door can be guarded by a monster which the player will have to interact with.
 */
public final class Door {
    private final Chamber a,b; // the two chambers that are being connected

    private Monster guard; // monster that potentially guards the door

    /**
     * Private constructor that initializes the door with static methods
     * @param a first chamber that the door connects
     * @param b second chamber that the door connects
     * @param m monster guarding the door
     */
    private Door(Chamber a, Chamber b, Monster m){
        this.a=a; this.b=b; this.guard=m;
    }

    /**
     * method to connect the two chambers without a monster guard
     * @param a First chamber that the door connects
     * @param b Second chamber that the door connects
     */
    public static void connect(Chamber a, chamber b) {connect(a,b,null);}

    /**
     * method to connect the two chambers with a monster guard
     * @param a First chamber that the door connects
     * @param b Second chamber that the door connects
     * @param m monster guarding the door
     */
    public static void connect(Chamber a, Chamber b, Monster m){
        Door d = new Door (a,b,m);
        a.addDoor(d);
        b.addDoor(d);
    }

    /**
     * Method to return the chamber that is connected to current chamber via door
     * @param c One chamber
     * @return the chamber that the door connects to
     */
    public Chamber other (Chamber c) {
        return c == a? b : a;
    }

    /**
     * Method that returns the monster guarding the door
     * @return the monster guard
     */
    public Monster getGuard() {
        return guard;
    }

    /**
     * method to remove the monster guard from the door
     */
    public void removeGuard() {
        guard = null; // sets the guard to null
    }

}
