package ants;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cell {
    private int x, y, scale;
    private boolean filled = false;

    public Cell(final int x, final int y, final int scale) {
	this.x = x;
	this.y = y;
	this.scale = scale;
    }

    public void fill(final boolean filled) {
	this.filled = filled;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public boolean isFilled() {
	return filled;
    }

    public void render(final Graphics2D g) {
	g.setColor(Color.BLACK);
	if (!filled) {
	    // g.drawRect(x, y, scale, scale);
	} else {
	    g.fillRect(x, y, scale, scale);
	}
    }
}
