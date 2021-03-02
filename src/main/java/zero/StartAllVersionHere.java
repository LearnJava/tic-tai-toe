package zero;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import zero.game_logic.Field;
import zero.graphics.SWING.Gui;
import zero.graphics.SWT.GuiSWT;

public class StartAllVersionHere {

    public final static Display display = new Display();
    public static Shell shell = new Shell(display, SWT.CLOSE);

    public static void main(String[] args) {


        RowLayout layoutForBasicShell = new RowLayout();
        layoutForBasicShell.type = SWT.VERTICAL;
        layoutForBasicShell.justify = true;
        shell.setLayout(layoutForBasicShell);

        Button startSwingVersion = new Button(shell, SWT.PUSH);
        Button startSWTVersion = new Button(shell, SWT.PUSH);

        startSwingVersion.setText("Start game into SWING mode");
        startSWTVersion.setText("Start game into SWT mode");

        startSwingVersion.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // Handle the selection event

                Field field = new Field();
                field.generateField();

                new Gui(field);
            }
        });

        startSWTVersion.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {

                if(shell.isDisposed()) {
                    shell = new Shell(display);
                }
                new GuiSWT(shell);
//                shell.dispose();
            }
        });

        shell.open();
        shell.pack();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}