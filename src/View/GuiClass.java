package View;

	import javax.swing.*;
	import java.awt.*;


import Model.*;
	public class GuiClass {
	    public static void main(String[] args) {
	        JFrame jFrame = new JFrame("Hola amigos");
	        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jFrame.setSize(300, 300);



	        LeftPanel leftPanel = new LeftPanel();
	        BoardPanel boardPanel = new BoardPanel();
	        RightPanel rightPanel = new RightPanel();
	        HandPanel handPanel = new HandPanel();
	        BorderLayout borderLayout = new BorderLayout();    

	        jFrame.add(rightPanel, borderLayout.EAST);
	        jFrame.add(boardPanel, borderLayout.CENTER);
	        jFrame.add(handPanel, borderLayout.SOUTH);
	        jFrame.add(leftPanel, borderLayout.WEST);
	        
	        leftPanel.setActionListener(new StringListener() {
	        	@Override
	        	public void TextEmitted(String text) {
	        		System.out.println(text);
	        	}
	        });
	        boardPanel.setActionListener(new BooleanListener() {
	        	@Override
	        	public void startGame(Boolean start) {

	        		do { // loop until we have correct input
		        		String m = JOptionPane.showInputDialog("How many players?\n Please enter a number between 3 and 6");
	        			try {
	        				int numberOfPlayers = Integer.parseInt(m);
	        				if (numberOfPlayers < 7 && numberOfPlayers > 2) {
	        					break; // Got valid input, stop looping
	        				} else {
	        					JOptionPane.showMessageDialog(null, "Please enter a number between 3 and 6");
	        					//popup window
	        					continue; // restart loop, didn't get an integer input
	        				}

	        			} catch (final Exception e) {
	        				JOptionPane.showMessageDialog(null, "Please enter a number between 3 and 6");
	        				//popup error window
	        				continue; // restart loop, didn't get an integer input
	        			}
	        		} while (true);
	        		CharacterSelect characters = new CharacterSelect();
	        		JOptionPane.showMessageDialog(null, characters);
	        		
	        		// Get list of players back from pop-up
	        		
	        		
	        		Game game = new Game();
	        		
	        		// set number of players in game
	        		// Set listOfPlayers in game
	        		
	        		game.gameSetup();
	        	}
	        });
	        jFrame.setVisible(true);
	        
	        
	    }


	}

