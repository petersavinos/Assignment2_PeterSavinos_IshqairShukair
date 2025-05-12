package oop350.action;

import oop350.model.Character;
import oop350.model.Item;
import oop350.model.Chamber;

public final class Pick implements Action {
    private final Character player;
    private final Item item;
    private final Chamber chamber;
    public Pick(Character player, Item item, Chamber chamber){
        this.player=player; this.item=item; this.chamber=chamber;
    }
    @Override public String description(){ return "Pick up " + item; }
    @Override public void execute(){
        chamber.getItems().remove(item);
        player.addItem(item);
        System.out.println("You picked up " + item);
    }
}
