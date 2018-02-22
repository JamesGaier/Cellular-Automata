package ants;

import java.awt.Dimension;
import java.awt.Frame;

import javax.swing.JFrame;

import ants.utils.Utilities;

public class Window extends JFrame {
    private static final long serialVersionUID = 1L;
    // Should these be private?
    KeyController kc;
    Simulation sim;

    public Window(final int width, final int height, final String title) {
	init();
	add(sim);
	setTitle(title);
	setFocusable(true);
	addKeyListener(kc);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	pack();
	setResizable(false);
	setMaximumSize(new Dimension(width, height));
	setMinimumSize(new Dimension(width, height));
	setVisible(true);
	sim.start();
	Utilities.frame = this;
    }

    public Window(final String title) {
	init();
	add(sim);
	setFocusable(true);
	addKeyListener(kc);
	setTitle(title);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setExtendedState(Frame.MAXIMIZED_BOTH);
	setUndecorated(true);
	setVisible(true);
	sim.start();
	Utilities.frame = this;
    }

    public void init() {
	kc = new KeyController();
	sim = new Simulation();
    }

}
