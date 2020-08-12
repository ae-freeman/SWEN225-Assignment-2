package View;

import java.awt.*;


import javax.swing.*;
public class BoardCanvas extends Canvas {
	public String actionPerformed() {
		String path = JOptionPane.showInputDialog("Enter a path");
		return path;
	}
	public void paint(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(5, 15, 50, 75);
	}
}
