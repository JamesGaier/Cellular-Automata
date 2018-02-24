package ants;

import javax.swing.JFrame;

import ants.utils.Direction;

public class Ant implements Runnable {
    private int x, y;
    private int dirX = 0, dirY = 1;

    // This is unused.
    private JFrame frame;

    private Grid grid;
    private Thread t1;
    private int dx = 1, dy = 1;
    private Direction dir;

    public Ant(final int x, final int y, final Grid grid, final JFrame frame) {
	this.x = x;
	this.y = y;
	this.frame = frame;
	this.grid = grid;
	dir = Direction.RIGHT;
    }

    @Override
    public void run() {
	while (true) {
	    boolean current = grid.getGrid()[x][y].isFilled();
	    grid.getGrid()[x][y].fill(!current);
	    if (!current) {
		turnRight();
	    } else {
		turnLeft();
	    }
	    x += dirX * dx;
	    y += dirY * dy;
	    try {
		Thread.sleep(20);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

    public void start() {
	t1 = new Thread(this);
	t1.start();
    }

    public void turnLeft() {
	if (dir == Direction.RIGHT) {
	    dir = Direction.UP;
	    dirX = 0;
	    dirY = -1;
	} else if (dir == Direction.LEFT) {
	    dir = Direction.DOWN;
	    dirX = 0;
	    dirY = 1;
	} else if (dir == Direction.UP) {
	    dir = Direction.LEFT;
	    dirY = 0;
	    dirX = -1;
	} else if (dir == Direction.DOWN) {
	    dir = Direction.RIGHT;
	    dirY = 0;
	    dirX = 1;
	}
    }

    public void turnRight() {
	if (dir == Direction.RIGHT) {
	    dir = Direction.DOWN;
	    dirX = 0;
	    dirY = 1;
	} else if (dir == Direction.LEFT) {
	    dir = Direction.UP;
	    dirX = 0;
	    dirY = -1;
	} else if (dir == Direction.UP) {
	    dir = Direction.RIGHT;
	    dirY = 0;
	    dirX = 1;
	} else if (dir == Direction.DOWN) {
	    dir = Direction.LEFT;
	    dirY = 0;
	    dirX = -1;
	}
    }

}
