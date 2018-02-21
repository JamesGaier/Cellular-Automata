import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = 1L;
	KeyController kc;
	Simulation sim;
	public void init() {
		kc = new KeyController();
		sim = new Simulation();
	}
	public Window(int width, int height, String title) {
		init();
		add(sim);
		setTitle(title);
		setFocusable(true);
		addKeyListener(kc);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pack();
		setResizable(false);
		setMaximumSize(new Dimension(width,height));
		setMinimumSize(new Dimension(width,height));
		setVisible(true);
		sim.start();
		Utilities.frame = this;
	}
	public Window(String title) {
		init();
		add(sim);
		setFocusable(true);
		addKeyListener(kc);
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		setVisible(true);
		sim.start();
		Utilities.frame = this;
	}
	
}
