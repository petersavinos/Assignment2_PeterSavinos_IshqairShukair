/**
 * Item class serves as the items in the game.
 * Items can give boosts in strength or craft.
 */
public abstract class Item {
    /**
     * Returns the strength boost that is given by the item
     * @return the strength boost
     */
    public int getStrength() {
        return 0;
    }

    /**
     * Returns the craft boost that is given by the item
     * @return the craft boost
     */
    public int getCraft() {
        return 0;
    }

    /**
     * Returns the string representation of an item
     * @return a name of the item
     */
    @Override public abstract String toString();
}
