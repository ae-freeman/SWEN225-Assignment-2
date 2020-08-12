package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI {
	
	private JFrame frame;
	private JPanel menuPanel;
	private JPanel boardPanel;
	private JPanel piecesPanel;
	private JPanel playerPanel;
	JMenuBar menuBar;

	
	private int WIDTH = 400;
	private int HEIGHT = 400;
	
	public GUI() {
		menuPanel();
	}
	
	public void menuPanel() {
		
		frame = new JFrame("Cluedo");
		frame.setSize(WIDTH, HEIGHT);
		
		menuPanel = new JPanel();
		menuBar = new JMenuBar();

		
		JButton startGame = new JButton("Start Game");
		startGame.addActionListener(e -> {
			startGame();
		});
		menuPanel.add(startGame);
		
		
		JButton nextPlayer = new JButton("Next Player");
		nextPlayer.addActionListener(e -> {
			nextPlayer();
		});
		menuPanel.add(nextPlayer);
		

		
		JButton nextTurn = new JButton("Next Turn");
		nextTurn.addActionListener(e -> {
			nextTurn();
		});
		menuPanel.add(nextTurn);
		
		JButton suggest = new JButton("Suggest");
		suggest.addActionListener(e -> {
			suggest();
		});
		menuPanel.add(suggest);
		
		JButton accuse = new JButton("Accuse");
		accuse.addActionListener(e -> {
			accuse();
		});
		menuPanel.add(accuse);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(e -> {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        });
		menuBar.add(exit);
		
		
		JMenuItem newGame = new JMenuItem("New Game");
		newGame.addActionListener(e -> {
			
        });
		menuBar.add(newGame);
		
		menuPanel.setLayout(new GridLayout(7, 1));
		
		frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.getContentPane().add(BorderLayout.WEST, menuPanel);
        JPanel panel= boardPanel();
        frame.add(panel);
        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(1000,1000);    
        frame.setLayout(null);    
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    


	}
	
	public JPanel boardPanel() { 
        JPanel panel=new JPanel(); 
        panel.setLocation(1000, 1000);
        panel.setBounds(40,80,200,200);    
        panel.setBackground(Color.gray);  
        JButton b1=new JButton("Button 1");     
        b1.setBounds(50,100,80,30);    
        b1.setBackground(Color.yellow);   
        JButton b2=new JButton("Button 2");   
        b2.setBounds(100,100,80,30);    
        b2.setBackground(Color.green);   
        panel.add(b1); panel.add(b2);
        return panel;
        }  
	
	
	public void playerPanel() {
		
	}
	
	public void nextPlayer() {
		
	}
	
	public void startGame() {
		
	}
	
	public void nextTurn() {
		
	}
	
	public void suggest() {
		
	}
	
	public void accuse() {
		
	}
	
	public void reset() {
		
		
	}
	
	
	public static void main(String[] args) {
		new GUI();
	}
}