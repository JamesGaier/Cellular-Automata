package ants;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Simulation extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;
    private boolean running;
    private Thread gameThread;
    // Should this be private?
    Grid myGrid;

    public void init() {
	myGrid = new Grid(getWidth(), getHeight(), 10);
    }

    public void render() {
	BufferStrategy bs = getBufferStrategy();
	if (bs == null) {
	    createBufferStrategy(3);
	    return;
	}
	final Graphics2D g2d = (Graphics2D) bs.getDrawGraphics();

	g2d.setColor(Color.WHITE);
	g2d.fillRect(0, 0, getWidth(), getHeight());
	myGrid.render(g2d);

	bs.show();
	g2d.dispose();
    }

    @Override
    public void run() {
	init();
	while (running) {
	    update();
	    render();
	}
    }

    public void start() {
	if (running)
	    return;
	running = true;
	gameThread = new Thread(this);
	gameThread.start();
    }

    public void update() {
    }

}
