package ru.zero.graphics.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import ru.zero.game_logic.ActionCounters;
import ru.zero.game_logic.Field;

class GraphicFieldSWT {

    private final Field field;
    public final SWTCellV2[][] groupOfCells = new SWTCellV2[Field.ROW_COUNT][Field.COL_COUNT];
    public final Composite composite;
    public static final byte NUMBER_OF_CELL = 9;
    private final static int weightCell = 150;
    private final static int heightCell = 150;

    public GraphicFieldSWT(Field field) {

        this.field = field;
        Composite compositeForButtons = new Composite(GuiSWT.shell, SWT.BORDER);

        composite = new Composite(GuiSWT.shell, SWT.BORDER);

        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        composite.setLayout(layout);

        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.widthHint = weightCell;
        gridData.heightHint = heightCell;

        Button buttonRestartGame = new Button(compositeForButtons, SWT.PUSH);
        Button buttonExit = new Button(compositeForButtons, SWT.PUSH);

        buttonRestartGame.setText("Press to restart");
        buttonExit.setText("Exit");

        buttonRestartGame.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                // Handle the selection event
                restartGameSWT();
            }
        });

        buttonExit.addSelectionListener(new SelectionAdapter() {

            public void widgetSelected(SelectionEvent e) {
                // Handle the selection event
                GuiSWT.shell.dispose();
            }
        });

        RowLayout layoutForButtons = new RowLayout();
        layoutForButtons.type = SWT.HORIZONTAL;
        compositeForButtons.setLayout(layoutForButtons);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                groupOfCells[i][j] = new SWTCellV2(field, this);
                groupOfCells[i][j].setgX(i);
                groupOfCells[i][j].setgY(j);
                groupOfCells[i][j].getCellV2().setLayoutData(gridData);

            }
        }

        restartGameSWT();
    }

    public void restartGameSWT() {

        ActionCounters.resetCounter();
        field.generateField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                Field.isWin = false;
                Field.isLose = false;
                Field.gameOver = false;

                groupOfCells[i][j].setgX(i);
                groupOfCells[i][j].setgY(j);
                groupOfCells[i][j].setIsZero(false);
                groupOfCells[i][j].setIsClean(true);
                groupOfCells[i][j].getCellV2().redraw();
            }
        }
    }
}