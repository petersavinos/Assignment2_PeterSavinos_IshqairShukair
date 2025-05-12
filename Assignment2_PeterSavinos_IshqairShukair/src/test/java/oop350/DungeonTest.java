package oop350;

import oop350.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for core Dungeon game mechanics.
 * These tests validate character stats, monster combat, and dungeon logic.
 */
public class DungeonTest {

    /**
     * Test that a wizard equipped with an Axe has a total strength of 3.
     * Axe gives +3 strength, wizard base strength is 0.
     */
    @Test
    void wizardStrengthPlusItem() {
        Wizard w = new Wizard("Merlin");
        w.addItem(new Axe());                          // Add Axe to inventory
        w.useItem(w.getInventory().get(0));            // Equip it
        assertEquals(3, w.getStrengthTotal());         // Should have +3 STR
    }

    /**
     * Test that a monster with 1 HP dies when taking 2 damage.
     */
    @Test
    void monsterDies() {
        Monster m = new Monster("Rat", 1, 0, 1);        // 1 HP monster
        m.damage(2);                                    // Deal 2 damage
        assertTrue(m.dead());                           // Should be dead
    }

    /**
     * Test that when a player enters a room with a guarded door,
     * the first available action is a Fight (not Move).
     */
    @Test
    void firstActionIsFightWhenMonsterAlive() {
        Chamber a = new Chamber();                      // Start room
        Chamber b = new Chamber();                      // Target room
        Monster m = new Monster("Orc", 1, 0, 5);         // Guarding monster
        Door.connect(a, b, m);                          // Connect with monster guarding

        oop350.model.Character p = new Warrior("Conan"); // Explicit reference to avoid name conflict
        Dungeon d = new Dungeon(p, a, b);               // Player starts in room A

        // The only door is guarded, so first action should be Fight
        assertTrue(d.getActions().get(0).description().startsWith("Fight"));
    }
}
