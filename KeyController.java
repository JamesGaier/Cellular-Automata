package ants;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyController implements KeyListener {
    @Override
    public void keyPressed(final KeyEvent e) {
	if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	    System.exit(0);
	}
    }

    @Override
    public void keyReleased(final KeyEvent e) {

    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

}
