package ru.zero.graphics.SWING.graphics_logics;

import ru.zero.game_logic.ActionCounters;
import ru.zero.game_logic.Cell;
import ru.zero.game_logic.Field;
import ru.zero.graphics.SWING.GraphicCell;
import ru.zero.graphics.SWING.GraphicField;
import ru.zero.graphics.SWING.Gui;

public class MouseClickedEvent {

	public void clickOnMouseLeftButton(Field logicField, GraphicCell gCell,
			GraphicField gField) {

		if (ActionCounters.getCounter() < GraphicField.NUMBER_OF_CELL
				&& !Field.gameOver) {
			Cell[][] array = logicField.getArray();

			Cell cell = array[gCell.getgX()][gCell.getgY()];

			boolean cellIsClearOrNot = cell.getIsClean();
			logicField.userMove((byte) gCell.getgX(), (byte) gCell.getgY());

			if (cellIsClearOrNot) {
                gCell.setClean(false);
                gCell.setZero(false);
				cell.userMove();
			} else {
				System.out.println("Make Repaint()");
                gCell.repaint();
				return;
			}

            gCell.repaint();
			ActionCounters.addOneAction();
			if (logicField.checkForWin()) {
				Gui.gamePanel.getContentPane().repaint();
				return;
			}

			Byte[] coordinatesCell;
			coordinatesCell = logicField.compMove();

			if (coordinatesCell == null) {
				System.out.println("Copm do not make action!!!");
				Field.isWin = true;
				Field.isLose = true;
				Gui.gamePanel.getContentPane().repaint();
				return;
			}

			int xx = coordinatesCell[0];
			int yy = coordinatesCell[1];
			GraphicCell graphicCell = gField.array[xx][yy];
			graphicCell.setClean(false);
			graphicCell.setZero(true);

			graphicCell.repaint();
			ActionCounters.addOneAction();
			if (logicField.checkForWin()) {
				Gui.gamePanel.getContentPane().repaint();
			}

		}
	}
}
