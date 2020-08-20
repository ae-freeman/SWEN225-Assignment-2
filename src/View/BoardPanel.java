package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import Model.Board;
import Model.Cell;
import Model.Room;

public class BoardPanel extends JPanel implements ActionListener {
	private JButton button1;
	private GameListener listener;

	public BoardPanel(){
		 setBackground(Color.PINK);
		 button1 = new JButton("Start Game");
		 button1.addActionListener(this);
	     BorderLayout borderLayout = new BorderLayout();
		 add(button1, borderLayout.PAGE_END);
	}
   public void setActionListener(GameListener actionListener) {
	   this.listener = actionListener;
   }
   @Override
   public void actionPerformed(ActionEvent e) {
	   listener.startGame();
	   button1.setVisible(false);
   }
   
   /**
    * Prints the board on the console, current player as X and other players as .
    * @param rooms An arraylist of all the rooms in the game
    */
   public void populateBoard(ArrayList<Room> rooms) {

	   Board board = new Board();
       for (int row = 0; row < 25; row++) {
           for (int col = 0; col < 24; col++) {
               char currentChar = board.getBoardString().charAt((row * 24) + col);
               Cell currentCell = new Cell(col, row);
               board.getBoard()[col][row] = currentCell;
               switch (currentChar) {
               
               	 case 'O':
               		 
               		 currentCell.setRoom(rooms.get(0));
               		 currentCell.addCellToRoom("Lounge", rooms);
               		 
 					break;
                  case 'D':
                      currentCell.setRoom(rooms.get(1));
                      currentCell.addCellToRoom("Dining Room", rooms);
 						break;
                   case 'K':
                       currentCell.setRoom(rooms.get(2));
                       currentCell.addCellToRoom("Kitchen", rooms);
                       break;
                   case 'H':
                       currentCell.setRoom(rooms.get(3));
                       currentCell.addCellToRoom("Hall", rooms);
 						break;
                   case 'C':
                       currentCell.setRoom(rooms.get(4));
                       currentCell.addCellToRoom("Conservatory", rooms);
 						break;
                   case 'I':
                       currentCell.setRoom(rooms.get(5));
                       currentCell.addCellToRoom("Billiard Room", rooms);
 						break;
                   case 'L':
                       currentCell.setRoom(rooms.get(6));
                       currentCell.addCellToRoom("Library", rooms);
 						break;
                   case 'S':
                       currentCell.setRoom(rooms.get(7));
                       currentCell.addCellToRoom("Study", rooms);
 						break;
                   case 'B':
                       currentCell.setRoom(rooms.get(8));
                       currentCell.addCellToRoom("Ballroom", rooms);
 						break;
                   case ' ':
                       currentCell.setRoom(rooms.get(9));
                       currentCell.addCellToRoom("Hallway", rooms);
 						break;
                   case '|':
                   case '_':
                       currentCell.setRoom(new Room("Wall"));
                       currentCell.setIsAccessible(false);
                       break;
                     case 'A':
                       currentCell.setRoom(new Room("Cellar"));
                       currentCell.setIsAccessible(false);
 						break;
 					default:
 						currentCell.setRoom(new Room("Default"));
 						break;
               }
           }
       }
   }

}

