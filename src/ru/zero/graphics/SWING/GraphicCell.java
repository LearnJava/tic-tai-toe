package ru.zero.graphics.SWING;

import ru.zero.game_logic.Field;
import ru.zero.graphics.SWING.graphics_logics.MouseClickedEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GraphicCell extends JComponent implements MouseListener {

    private final static int WIDTH = 32;
    private final static int HEIGHT = 32;
    private static final int SPACE = 10;
    private boolean isSelected = false;

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public void setZero(boolean zero) {
        isZero = zero;
    }

    private boolean isClean = true;
    private boolean isZero;

    public int getgX() {
        return gX;
    }

    public int getgY() {
        return gY;
    }

    private final int gX;
    private final int gY;
    private final Field logicField;
    private final GraphicField gField;

    public GraphicCell(Field logicField, GraphicField gField, int x, int y) {
        this.logicField = logicField;
        this.gField = gField;
        this.gX = x;
        this.gY = y;
        setSize(WIDTH, HEIGHT);
        addMouseListener(this);
    }

    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        int lw = getWidth() - 1;
        int lh = getHeight() - 1;
        int rw = GraphicField.SPACE_BETWEEN * 2;
        int rh = GraphicField.SPACE_BETWEEN * 2;

        BasicStroke pen = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);

        Color color = Color.red;

        if (isSelected) {
            color = Color.green;
        }

        g2d.setPaint(new GradientPaint(lw, lh, Color.white, lw / 4, lh / 4, color, true));
        g2d.fillRoundRect(0, 0, lw, lh, rw, rh);
        g2d.setColor(color);
        g2d.drawRoundRect(0, 0, lw, lh, rw, rh);

        if (!isClean && !isZero) {
            g2d.setStroke(pen);
            g2d.setColor(Color.black);
            g2d.drawLine(SPACE, SPACE, getWidth() - SPACE, getHeight() - SPACE);
            g2d.drawLine(getWidth() - SPACE, SPACE, SPACE, getHeight() - SPACE);
        } else if (!isClean) {
            g2d.setStroke(pen);
            g2d.setColor(Color.black);
            g2d.drawOval(SPACE, SPACE, getWidth() - 2 * SPACE, getHeight() - 2 * SPACE);
        }

    }

    public void mouseEntered(MouseEvent e) {
        if(!Field.gameOver) {
        isSelected = true;
        repaint();
        }
    }

    public void mouseExited(MouseEvent e) {
        if(!Field.gameOver) {
            isSelected = false;
            repaint();
        }
    }

    public void mouseClicked(MouseEvent e) {

        new MouseClickedEvent().clickOnMouseLeftButton(logicField, this, gField);

    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
}