package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HandPanel extends JPanel implements ActionListener {
	private JLabel label;
	private JButton button1;
	private StringListener listener;
	
	public HandPanel(){
		 setBackground(Color.MAGENTA);
		 button1 = new JButton("Oprimir");
		 button1.addActionListener(this);
		 label = new JLabel("Buttons");
	        BorderLayout borderLayout = new BorderLayout();
		 add(label, borderLayout.NORTH);
		 add(button1, borderLayout.NORTH);

	}
   public void setActionListener(StringListener listener) {
	   this.listener = listener;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	   listener.TextEmitted("ButtonPressed");
   }

}

