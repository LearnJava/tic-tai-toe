package ru.zero.graphics.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import ru.zero.StartAllVersionHere;
import ru.zero.game_logic.ActionCounters;
import ru.zero.game_logic.Cell;
import ru.zero.game_logic.Field;

class MouseClickedEventSWT {

	private final Field logicField;
	private final GraphicFieldSWT gFieldSWT;

	public MouseClickedEventSWT(Field logicField, SWTCellV2 gCell,
			final GraphicFieldSWT gFieldSWT) {

		this.gFieldSWT = gFieldSWT;
		this.logicField = logicField;

		if (ActionCounters.getCounter() < GraphicFieldSWT.NUMBER_OF_CELL
				&& !Field.gameOver) {

            Cell[][] array = logicField.getArray();
            Cell cell = array[gCell.getgX()][gCell.getgY()];

			boolean cellIsClearOrNot = cell.getIsClean();

			if (cellIsClearOrNot) {
				logicField.userMove((byte) gCell.getgX(), (byte) gCell.getgY());
				gCell.setIsClean(false);
				gCell.setIsZero(false);
				ActionCounters.addOneAction();
				if (checkForWinSWT()) {

					return;
				}

				Byte[] coordinatesCell;
				coordinatesCell = logicField.compMove();
                int xx = coordinatesCell[0];
                int yy = coordinatesCell[1];
                SWTCellV2 graphicCell = gFieldSWT.groupOfCells[xx][yy];
                graphicCell.setIsClean(false);
                graphicCell.setIsZero(true);
                System.out.println("Координаты последнего хлда компа. Х=" + xx +" Y=" + yy );
				ActionCounters.addOneAction();

//				if (coordinatesCell == null) {
//					System.out.println("Компьютеру некуда ходить!!!");
//					Field.isWin = true;
//					Field.isLose = true;
//					return;
//				}

				graphicCell.drawXorO();

				checkForWinSWT();

			} else {
				System.out.println("Ячейка уже занята");
			}
        }

//        System.out.println("Stop MouseClickedEventSWT");
    }

	private boolean checkForWinSWT() {
		if (logicField.checkForWin()) {

			final Shell dialog = new Shell(GuiSWT.shell, SWT.DIALOG_TRIM
					| SWT.APPLICATION_MODAL);
			Font fontForDialog = new Font(StartAllVersionHere.display, "Arial", 14, SWT.BOLD
					| SWT.ITALIC);

			RowLayout layoutForDialogWindow = new RowLayout();
			layoutForDialogWindow.type = SWT.VERTICAL;
			layoutForDialogWindow.pack = false;
			dialog.setText("Win Or Lose Window");
			dialog.setLayout(layoutForDialogWindow);

			Label label = new Label(dialog, SWT.BORDER);
			label.setFont(fontForDialog);
			if (Field.isWin && Field.isLose) {
				label.setText("Ничья");
			} else if (Field.isWin && !Field.isLose) {
				label.setText("Вы победили");
			} else if (!Field.isWin && Field.isLose) {
				label.setText("Вы проиграли");
			} else {
				System.out.println("Такого быть не может");
			}

			Button button = new Button(dialog, SWT.PUSH | SWT.CENTER);
			button.setText("Press to restart");

			dialog.forceActive();
			dialog.pack();
			dialog.open();

			button.addSelectionListener(new SelectionAdapter() {

				public void widgetSelected(SelectionEvent e) {
					gFieldSWT.restartGameSWT();
					dialog.dispose();
				}
			});
			return true;
		}
		return false;
	}
}
