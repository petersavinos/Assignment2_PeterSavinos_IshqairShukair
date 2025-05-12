package oop350.action;

import oop350.model.*;

public final class Move implements Action {
    private final Dungeon dungeon;
    private final Door door;
    public Move(Dungeon dungeon, Door door){
        this.dungeon=dungeon; this.door=door;
    }
    @Override public String description(){ return "Move through door"; }
    @Override public void execute(){
        if(door.getGuard()!=null){
            System.out.println("A " + door.getGuard() + " blocks the way!");
            return;
        }
        dungeon.setCurrentChamber(door.other(dungeon.getCurrentChamber()));
        System.out.println("You move into the next chamber.");
    }
}
