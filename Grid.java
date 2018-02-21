import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Grid {
	private Cell[][] grid;
	private Ant ant;
	public Grid(int width, int height,int scale) {
		grid = new Cell[(width/scale)+2][(height/scale)+2];
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell(i*scale,j*scale,scale);
			}
		}
		int startX = grid.length/2;
		int startY = grid[0].length/2;
		ant = new Ant(startX,startY,this,Utilities.frame);
		ant.start();
	}
	public Cell[][] getGrid(){
		return grid;
	}
	public void render(Graphics2D g) {
		for(Cell[] c : grid) {
			for(Cell c1 : c) {
				c1.render(g);
			}
		}
	}
	
}
