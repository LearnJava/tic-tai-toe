package ru.zero.graphics.SWING;

import ru.zero.game_logic.ActionCounters;
import ru.zero.game_logic.Field;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicField extends JComponent implements ActionListener {

    private static final int SECTOR_COUNT = 3;
    public static final int SPACE_BETWEEN = 2;
    public static final byte NUMBER_OF_CELL = 9;
    public final GraphicCell[][] array = new GraphicCell[SECTOR_COUNT][SECTOR_COUNT];

    private final Field field;

    Field getField() {
        return field;
    }

    public GraphicField(Field field) {
        this.field = field;

        this.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < SECTOR_COUNT; i++) {
            for (int j = 0; j < SECTOR_COUNT; j++) {
                array[i][j] = new GraphicCell(field,this, i, j);

                add(array[i][j]);
            }
        }
        System.out.print("forStop");
    }

    void restartGame() {

        ActionCounters.resetCounter();
        getField().generateField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                GraphicCell c = array[i][j];
                c.setClean(true);
                c.setZero(false);
                Field.isWin = false;
                Field.isLose = false;
                Field.gameOver = false;

                c.repaint();
            }
        }
    }

    public void paint(Graphics g) {

        if(Field.isWin || Field.isLose) {
            Graphics2D g2d = (Graphics2D)g;
            System.out.println("THIS IS GAME END");
            paintWinOrLoseMessage(g2d);
        } else {
            super.paint(g);
        }
    }

    private void paintWinOrLoseMessage(Graphics2D g2d) {

        g2d.scale(getWidth() / 53, getHeight() / 36);
        if( Field.isWin && Field.isLose) {
            g2d.setColor(Color.BLUE);
            g2d.drawString("No Winer", 11, 20);
        } else if (Field.isWin && !Field.isLose) {
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawString("WIN", 17, 20);
        } else if (!Field.isWin && Field.isLose) {
            g2d.setColor(Color.magenta);
            g2d.drawString("LOSE", 14, 20);
        } else {
            System.out.println("error");
        }
    }

    public void actionPerformed(ActionEvent e) {
        restartGame();
    }

}