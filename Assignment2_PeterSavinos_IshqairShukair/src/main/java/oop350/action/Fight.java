package oop350.action;

import oop350.model.Monster;
import oop350.model.Door;
import oop350.model.Character;

/**
 * Represents a combat action between a player and a monster guarding a door.
 * Implements the Action interface so it can be selected from the dungeon UI.
 */
public final class Fight implements Action {
    private final Character player; // the player initiating the fight
    private final Monster monster;  // the monster guarding the door
    private final Door door;        // the door being guarded

    /**
     * Constructs a Fight action.
     * @param player the character performing the action
     * @param door the door being guarded by the monster
     */
    public Fight(Character player, Door door){
        this.player = player;
        this.door = door;
        this.monster = door.getGuard();
    }

    /**
     * Returns a string describing the action (used in the action menu).
     */
    @Override
    public String description() {
        return "Fight monster " + monster;
    }

    /**
     * Executes the fight: rolls dice, applies damage, removes monster if dead.
     */
    @Override
    public void execute() {
        // Safety check: monster might already be gone
        if (monster == null) {
            System.out.println("No monster here.");
            return;
        }

        // Determine whether to use strength or craft based on monster type
        int playerRoll = player.roll() +
                (monster.getCraft() == 0 ? player.getStrengthTotal() : player.getCraftTotal());
        int monsterRoll = monster.roll() +
                (monster.getCraft() == 0 ? monster.getStrength() : monster.getCraft());

        // Player wins: damage monster
        if (playerRoll >= monsterRoll) {
            monster.damage(playerRoll - monsterRoll);
            System.out.printf("You hit the %s for %d damage!%n", monster, playerRoll - monsterRoll);
            if (monster.dead()) {
                System.out.println("Monster defeated!");
                door.removeGuard(); // unblock the door
            }

            // Monster wins: damage player
        } else {
            int dmg = monsterRoll - playerRoll;
            player.damage(dmg);
            System.out.printf("The %s hits you for %d damage!%n", monster, dmg);
        }
    }
}
