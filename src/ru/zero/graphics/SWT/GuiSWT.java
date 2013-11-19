package ru.zero.graphics.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Shell;
import ru.zero.StartAllVersionHere;
import ru.zero.game_logic.Field;

public class GuiSWT {


    //	public static final Shell shell = new Shell(StartAllVersionHere.display);
    public static final Shell shell = new Shell(StartAllVersionHere.shell, SWT.DIALOG_TRIM
            | SWT.APPLICATION_MODAL);

    public GuiSWT(Shell parentShell) {
        Field field = new Field();
        field.generateField();

        RowLayout layoutForShell = new RowLayout();
        layoutForShell.type = SWT.VERTICAL;

        shell.setText("Test");
        shell.setLayout(layoutForShell);

        new GraphicFieldSWT(field);

        shell.open();
        shell.pack();

    }
}
