package View;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

public class CharacterSelect extends JPanel implements ActionListener {
	JRadioButton option1 = new JRadioButton("Miss Scarlett");
	JRadioButton option2 = new JRadioButton("Colonel Mustard");
	JRadioButton option3 = new JRadioButton("Professor Plum");
	JRadioButton option4 = new JRadioButton("Mr Green");
	JRadioButton option5 = new JRadioButton("Mrs White");
	JRadioButton option6 = new JRadioButton("Mrs Peacock");

	public CharacterSelect(){
		ButtonGroup group = new ButtonGroup();
	    group.add(option1);	
	    group.add(option2);
	    group.add(option3);
	    group.add(option4);
	    group.add(option5);
	    group.add(option6);
	    setVisible(true);
	}
    
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}


