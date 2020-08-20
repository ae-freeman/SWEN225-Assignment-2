package View;

	import javax.swing.*;
	import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.*;
	public class GuiClass {
	    public static void main(String[] args) {
    		Game game = new Game();
    		game.gameSetup();
	        JFrame jFrame = new JFrame("Hola amigos");
	        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jFrame.setSize(1920, 1080);



	        MenuPanel leftPanel = new MenuPanel();
	        InputPanel left2Panel = new InputPanel();
	        JPanel leftMainPanel = new JPanel();
	        leftMainPanel.setLayout(new BorderLayout());
	        leftMainPanel.add(leftPanel, BorderLayout.WEST);
	        leftMainPanel.add(left2Panel, BorderLayout.EAST);
	        
	        
	        BoardPanel boardPanel = new BoardPanel();
	        ButtonGrid buttonGrid = new ButtonGrid(game);
	        boardPanel.add(buttonGrid);
	        RightPanel rightPanel = new RightPanel();
	        HandPanel handPanel = new HandPanel();
 

	        jFrame.add(rightPanel, BorderLayout.EAST);
	        jFrame.add(boardPanel, BorderLayout.CENTER);
	        jFrame.add(handPanel, BorderLayout.SOUTH);
	        jFrame.add(leftMainPanel, BorderLayout.WEST);

	        
	        boardPanel.setActionListener(new GameListener(){
	        	public void startGame() {
	        		do { // loop until we have correct input
		        		String m = JOptionPane.showInputDialog("How many players?\n Please enter a number between 3 and 6");
	        			try {
	        				int numberOfPlayers = Integer.parseInt(m);
	        				if (numberOfPlayers < 7 && numberOfPlayers > 2) {
	        					game.setNumberOfPlayers(numberOfPlayers);
	        					break; // Got valid input, stop looping
	        				} else {
	        					JOptionPane.showMessageDialog(null, "Please enter a number between 3 and 6");
	        					//popup window
	        					continue; // restart loop, didn't get an integer input
	        				}

	        			} catch (final Exception error) {
	        				JOptionPane.showMessageDialog(null, "Please enter a number between 3 and 6");
	        				//popup error window
	        				continue; // restart loop, didn't get an integer input
	        			}
	        		} while (true);
	        		CharacterSelect characters = new CharacterSelect();
	        		generatePlayers();
	        	}
				@Override
				public void generatePlayers() {
					
				}
//						left2Panel.setActionListener(new EnterListener() {
//							public void enterPlayers() {
//				        		do { // loop until we have correct input
//					        		left2Panel.changeDisplay("Please enter the names of each player");
//					                left2Panel.getInput.addMouseListener(new MouseAdapter(){
//					                    @Override
//					                    public void mouseClicked(MouseEvent e){
//					                        textField.setText("");
//					                    }
//					                });
//				        			try {
//				        				if (game.getPlayers().size() < game.getNumberOPlayers()) {
//				        					
//				        					break; // Got valid input, stop looping
//				        				} else {
//				        					left2Panel.changeDisplay("Please enter the remaining player's names");
//				        					//popup window
//				        					continue; // restart loop, didn't get an integer input
//				        				}
//
//				        			} catch (final Exception error) {
//				        				JOptionPane.showMessageDialog(null, "Please enter a number between 3 and 6");
//				        				//popup error window
//				        				continue; // restart loop, didn't get an integer input
//				        			}
//				        		} while (true);
//				        		CharacterSelect characters = new CharacterSelect();
//				        		generatePlayers();
//							}
//						});
//		    		}
//				}
	        });
	        leftPanel.setActionListener(new StringListener() {
	        	@Override
	        	public void TextEmitted(String text) {
	        		if(text.equals("End Game")) {
	        			System.out.println("EndGmae");
	        			game.setGameOver(true);
	        		}
	        		if(text.equals("End Turn")) {
	        			
	        		}
	        		if(text.equals("Suggest")) {
	        			
	        		}
	        		if(text.equals("Accuse")) {
	        			
	        		}
	        	}
	        	
	        });
	        	
	        jFrame.setVisible(true);


	    }


	}

