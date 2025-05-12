package oop350.model;

public final class Axe extends Item {
    @Override public int getStrength() { return 3; }
    @Override public String toString() { return "Axe (+3 STR)"; }
}
