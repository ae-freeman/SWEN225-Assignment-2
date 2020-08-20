
package View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Model.Card;

public class InputPanel extends JPanel implements ActionListener {
	private JButton enterButton;
	private JTextField textField;
	private JTextArea previous;
	private int WIDTH = 200;
	private int HEIGHT = 20;
	ArrayList<String> display = new ArrayList<String>();

	public InputPanel(){
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.white);
		buttonPanel.setLayout(new BorderLayout());

		Font font1 = new Font("SansSerif", Font.BOLD, 20);
		setBackground(Color.white);
		setLayout(new BorderLayout());

		previous = new JTextArea();
		previous.setBackground(Color.white);
		buttonPanel.add(previous, BorderLayout.CENTER);

		enterButton = new JButton("Enter");
		enterButton.getPreferredSize();
		enterButton.addActionListener(this);
		buttonPanel.add(enterButton, BorderLayout.PAGE_END);

		textField = new JTextField(""); 
		textField.setFont(font1);
		textField.setPreferredSize(new Dimension(WIDTH, 40));


		add(buttonPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.PAGE_END);

	}
	public void changeDisplay(String t){
		display.add(t);
		String inputs = new String();
		for(String string : display) {
			inputs += string + "\n";
		}
		previous.setText(inputs);
		System.out.println(inputs);
		textField.setText("");
	}
	public void setPrevious(String t) {
		previous.setText(t);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		changeDisplay(textField.getText());

	}
	//	   
	//	   public void characterInput(ArrayList<Card> characters) {
	//		   textField.setVisible(false);
	//		   String[] characterList = new String[6];
	//		   int i = 0;
	//		   for(Card card : characters) {
	//			   characterList[i] = card.getName();
	//			   i++;
	//		   }
	//		 //Create the combo box, select item at index 4.
	//		 //Indices start at 0, so 4 specifies the pig.
	//		 JComboBox characterselect = new JComboBox(characterList);
	//		 characterselect.setSelectedIndex(4);
	//		 characterselect.addActionListener(this);
	//		 add(characterselect, BorderLayout.PAGE_END);
	//		 characterselect.setPreferredSize(new Dimension(WIDTH, 40));
	//		   
	//	   }
	public void setActionListener(EnterListener enterListener) {
		// TODO Auto-generated method stub
		
	}
}


