package ru.zero.graphics.SWT;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import ru.zero.StartAllVersionHere;
import ru.zero.game_logic.Field;

public class SWTCellV2 {

	private final Field logicField;
	private final GraphicFieldSWT graphicFieldSWT;
	private final Canvas cellV2;
	private boolean isClean = true;
	private boolean isZero;
	private int gX, gY;
	private final Font fontForCellV2;

	public Canvas getCellV2() {
		return cellV2;
	}

	public void setIsClean(boolean clean) {
		isClean = clean;
	}

	public void setIsZero(boolean zero) {
		isZero = zero;
	}

	public int getgX() {
		return gX;
	}

	public int getgY() {
		return gY;
	}

	public void setgX(int gX) {
		this.gX = gX;
	}

	public void setgY(int gY) {
		this.gY = gY;
	}

	public SWTCellV2(Field field, final GraphicFieldSWT graphicFieldSWT) {

		this.logicField = field;
		this.graphicFieldSWT = graphicFieldSWT;

		fontForCellV2 = new Font(StartAllVersionHere.display, "Arial", 14, SWT.BOLD
				| SWT.ITALIC);

		cellV2 = new Canvas(graphicFieldSWT.composite, SWT.BORDER);
		cellV2.setBackground(new Color(StartAllVersionHere.display, 225, 216, 182));

		cellV2.addListener(SWT.MouseUp, new Listener() {
			public void handleEvent(Event event) {

				drawXorO();

			}
		});

		cellV2.addMouseTrackListener(new MouseTrackListener() {

			@Override
			public void mouseEnter(MouseEvent mouseEvent) {
				cellV2.setBackground(new Color(StartAllVersionHere.display, 225, 182, 215));
			}

			@Override
			public void mouseExit(MouseEvent mouseEvent) {
				cellV2.setBackground(new Color(StartAllVersionHere.display, 225, 216, 182));
			}

			@Override
			public void mouseHover(MouseEvent mouseEvent) {
				// To change body of implemented methods use File | Settings |
				// File Templates.
			}
		});
	}

	public void drawXorO() {
		if (!isZero) {
			new MouseClickedEventSWT(logicField, this, graphicFieldSWT);
		}

		cellV2.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {

				e.gc.setFont(fontForCellV2);

				Rectangle clientArea = cellV2.getClientArea();

				if (!isClean && !isZero) {
					e.gc.setLineWidth(4);
					e.gc.drawLine(clientArea.width / 5, clientArea.height / 5,
							clientArea.width - clientArea.width / 5,
							clientArea.height - clientArea.height / 5);
					e.gc.drawLine(clientArea.width - clientArea.width / 5,
							clientArea.height / 5, clientArea.width / 5,
							clientArea.height - clientArea.height / 5);

				} else if (isZero) {
					e.gc.setLineWidth(4);
					e.gc.drawOval(clientArea.width / 5, clientArea.height / 5,
							90, 90);
				}
			}
		});
        this.cellV2.redraw();
	}
}
