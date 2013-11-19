package ru.zero.game_logic;

public class ActionCounters {

    private static byte counter;

    public static byte getCounter() {
        return counter;
    }

    public static void addOneAction() {
        ++counter;
    }

    public static void resetCounter() {
        counter = 0;
    }

}
