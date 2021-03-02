package zero.graphics.SWING.graphics_logics;


import zero.game_logic.ActionCounters;
import zero.game_logic.Cell;
import zero.game_logic.Field;
import zero.graphics.SWING.GraphicCell;
import zero.graphics.SWING.GraphicField;
import zero.graphics.SWING.Gui;

public class MouseClickedEvent {

    //	private Field logicField;

	public void clickOnMouseLeftButton(Field logicField, GraphicCell gCell,
			GraphicField gField) {

//        GraphicCell graphicCell1 = gCell;

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
				System.out.println("Ничего не ставлю, просто делаю Repaint()");
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
				System.out.println("Компьютеру некуда ходить!!!");
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
