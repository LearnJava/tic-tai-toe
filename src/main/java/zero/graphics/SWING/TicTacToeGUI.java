package zero.graphics.SWING;


import zero.game_logic.Field;

public class TicTacToeGUI {

    public static void main(String[] args) {

        Field field = new Field();
        field.generateField();

        new Gui(field);
    }
}