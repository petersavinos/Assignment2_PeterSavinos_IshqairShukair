package oop350.action;

import oop350.model.Monster;
import oop350.model.Door;
import oop350.model.Character;

public final class Fight implements Action {
    private final Character player;
    private final Monster monster;
    private final Door door;
    public Fight(Character player, Door door){
        this.player=player; this.door=door; this.monster=door.getGuard();
    }
    @Override public String description(){
        return "Fight monster " + monster;
    }
    @Override public void execute(){
        if(monster==null){
            System.out.println("No monster here.");
            return;
        }
        int playerRoll = player.roll() + (monster.getCraft()==0? player.getStrengthTotal():player.getCraftTotal());
        int monsterRoll = monster.roll() + (monster.getCraft()==0? monster.getStrength():monster.getCraft());

        if(playerRoll>=monsterRoll){
            monster.damage(playerRoll - monsterRoll);
            System.out.printf("You hit the %s for %d damage!%n", monster, playerRoll-monsterRoll);
            if(monster.dead()){
                System.out.println("Monster defeated!");
                door.removeGuard();
            }
        }else{
            int dmg = monsterRoll - playerRoll;
            player.damage(dmg);
            System.out.printf("The %s hits you for %d damage!%n", monster, dmg);
        }
    }
}
