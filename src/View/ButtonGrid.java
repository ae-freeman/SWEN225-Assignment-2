package View;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Model.Board;
import Model.Cell;
import Model.Game;
import Model.Room;

public class ButtonGrid extends JPanel {
    private Game game;
    private Board board;
    
    public ButtonGrid(Game game, Board board) { // constructor
        this.game = game;
        this.board = board;
		setPreferredSize(new Dimension(1000, 1000));

    }
@Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for (int row = 0; row < 25; row++) {
    		for (int col = 0; col < 24; col++) {
    			int coordx = getWidth() * col / 24;
    			int coordy = getHeight() * row / 25;
                Cell currentCell = board.getBoard()[col][row];

                if(currentCell.getRoom().getName().equals("Hallway")) {
        			g.setColor(Color.BLACK);
                	g.fillRect(coordx, coordy, 800, 800);
                }
                if(currentCell.getRoom().getName().equals("Wall")) {
                	g.setColor(Color.WHITE);
                	g.fillRect(coordx, coordy, 800, 800);
                }
                else {
                	g.setColor(Color.CYAN);
                	g.fillRect(coordx, coordy, 800, 800);
                }
    		}
  }
//        for(Room room : game.getRooms()) {
//    		if(!room.getName().equals("Hallway")) {
//    			System.out.println(room.getCells().size());
//	        	for(Cell cell : room.getCells()) {
//	    			g.setColor(Color.black);
//	        		int coordx = getWidth() * cell.getXValue() / 24;
//	        		int coordy = getHeight() * cell.getYValue()/ 25;
//	        		
//	        		g.setColor(Color.cyan);
//	        	}
//	            System.out.println(g.getColor());
//    		}
//    		else {
//        		
//    			System.out.println(room.getCells().size());
//	        	for(Cell cell : room.getCells()) {  			
//	        		int coordx = getWidth() * cell.getXValue() / 24;
//	        		int coordy = getHeight() * cell.getYValue()/ 25;
//	        		g.fillRect(coordx, coordy, 800, 800);
//	        	}
//	            System.out.println(g.getColor());
//    		}
        }


//            	g.fillRect(coordx, coordy, 800, 800);
//            	char currentChar = board.getBoardString().charAt((row * 24) + col);
//                Cell currentCell = new Cell(col, row);
//                board.getBoard()[col][row] = currentCell;
//                switch (currentChar) {
//                
//                	 case 'O':
//                		 g.setColor(Color.CYAN);
//                		 g.fillRect(coordx, coordy, 800, 800);
                }
                
//                		 currentCell.setRoom(rooms.get(0));
//                		 currentCell.addCellToRoom("Lounge", rooms);
//                		 
//  					break;
//                   case 'D':
//              		 g.setColor(Color.CYAN);
//              		 g.fillRect(coordx, coordy, 800, 800);
////                       currentCell.setRoom(rooms.get(1));
////                       currentCell.addCellToRoom("Dining Room", rooms);
////  						break;
//                    case 'K':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(2));
////                        currentCell.addCellToRoom("Kitchen", rooms);
////                        break;
//                    case 'H':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(3));
////                        currentCell.addCellToRoom("Hall", rooms);
////  						break;
//                    case 'C':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(4));
////                        currentCell.addCellToRoom("Conservatory", rooms);
////  						break;
//                    case 'I':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(5));
////                        currentCell.addCellToRoom("Billiard Room", rooms);
////  						break;
//                    case 'L':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(6));
////                        currentCell.addCellToRoom("Library", rooms);
////  						break;
//                    case 'S':
//               		 g.setColor(Color.CYAN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(7));
////                        currentCell.addCellToRoom("Study", rooms);
////  						break;
//                    case 'B':
//               		 g.setColor(Color.BLUE);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(8));
////                        currentCell.addCellToRoom("Ballroom", rooms);
////  						break;
//                    case ' ':
//               		 g.setColor(Color.GREEN);
//               		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(rooms.get(9));
////                        currentCell.addCellToRoom("Hallway", rooms);
////  						break;
////                    case '|':
////                    case '_':
////               		 g.setColor(Color.BLACK);
////               		 g.fillRect(coordx, coordy, 800, 800);
//////                        currentCell.setRoom(new Room("Wall"));
//////                        currentCell.setIsAccessible(false);
//////                        break;
////                      case 'A':
////                 		 g.setColor(Color.BLACK);
////                 		 g.fillRect(coordx, coordy, 800, 800);
////                        currentCell.setRoom(new Room("Cellar"));
////                        currentCell.setIsAccessible(false);
////  						break;
////  					default:
////                		 g.setColor(Color.CYAN);
////                		 g.fillRect(coordx, coordy, 800, 800);
////  						currentCell.setRoom(new Room("Default"));
////  						break;
//                }
//            }
//        }
//            
//        
//            	char currentChar = board.getBoardString().charAt((row * 24) + col);
//                Cell currentCell = new Cell(col, row);
//                board.getBoard()[col][row] = currentCell;
//                switch (currentChar) {

            
        
    
