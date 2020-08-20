package View;
import java.awt.*;
 import javax.swing.*;
 public class Grid extends JComponent {

 

public Grid()    {       
 setSize( 500, 500 );
 setVisible( true ); 
 } 
@Override 
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.red);
		g2.fillRect(0, 0, 500, 500);
	}
 }
