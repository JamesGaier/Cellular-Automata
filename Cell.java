import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Comparator;

public class Cell{
	private int x,y,scale;
	private boolean filled = false;
	public Cell(int x, int y,int scale) {
		this.x = x;
		this.y = y;
		this.scale = scale;
	}
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		if(!filled) {
			//g.drawRect(x, y, scale, scale);
		}
		else {
			g.fillRect(x, y, scale, scale);
		}
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
	public void fill(boolean filled) {
		this.filled = filled;
	}
}
