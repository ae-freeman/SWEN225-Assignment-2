package View;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MenuPanel extends JPanel implements ActionListener {
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JLabel label;
	private JLabel label2;
	private int WIDTH = 200;
	private int HEIGHT = 20;
	private StringListener listener;
	
	public MenuPanel(){
		Color color = new Color(100, 100, 100);
		setBackground(color);
		setLayout(new GridLayout(5,2,0,30));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		 
		 button1 = new JButton("End Game");
		 button1.setActionCommand("End Game");
		 button1.addActionListener(this);
		 
		 button2 = new JButton("End Turn");
		 button2.setActionCommand("End Turn");
		 button2.addActionListener(this);

		 
		 button3 = new JButton("Suggest");
		 button3.setActionCommand("Suggest");
		 button3.addActionListener(this);

		 
		 button4 = new JButton("Accuse");		
		 button4.setActionCommand("Accuse");
		 button4.addActionListener(this);
		
		 label = new JLabel("Me", SwingConstants.RIGHT);
		 Font font = new Font("SansSerif", Font.BOLD, 60);
		 label.setFont(font);
		 label2 = new JLabel("nu", SwingConstants.LEFT);
		 label2.setFont(font);
		 add(new JLabel(""));
		 add(new JLabel(""));
		 add(button1);
		 add(button2); 
		 add(label);
		 add(label2);
		 add(button3);
		 add(button4);
		 add(new JLabel(""));
		 add(new JLabel(""));

	}
   public void setActionListener(StringListener listener) {
	   this.listener = listener;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	  listener.TextEmitted(e.getActionCommand());

   }

}

