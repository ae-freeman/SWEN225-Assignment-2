package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BoardPanel extends JPanel implements ActionListener {
	private JLabel label;
	private JButton button1;
	private BooleanListener listener;
	
	public BoardPanel(){
		 setBackground(Color.PINK);
		 button1 = new JButton("Start Game");
		 button1.addActionListener(this);
		 label = new JLabel("Buttons");
	     BorderLayout borderLayout = new BorderLayout();
		 add(label, borderLayout.NORTH);
		 add(button1, borderLayout.PAGE_END);
	}
   public void setActionListener(BooleanListener listener) {
	   this.listener = listener;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	   listener.startGame(true);
   }

}

