package zero.game_logic;

public class ActionCounters {

    private static byte counter; // TODO если мы предполагаем создание объекта ActionCounters то статическим делать это поле не очень хорошо
                                 // TODO или нам не нужно делать public ActionCounters aCounter = new ActionCounters(); (РАЗОБРАЛ)
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
