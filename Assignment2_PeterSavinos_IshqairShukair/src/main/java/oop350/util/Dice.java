package oop350.util;

import java.util.concurrent.ThreadLocalRandom;

/** Utility class: rolls a six‑sided die. */
public final class Dice {
    private Dice() {}
    public static int roll() { return ThreadLocalRandom.current().nextInt(1, 7); }
}
