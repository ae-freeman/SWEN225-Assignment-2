package Model;
import java.util.ArrayList;

public class Board
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Board Associations
    private Cell[][] board;
    private int LENGTH = 25;
    private int WIDTH = 24;
    private String boardString =
            "_________ ____ _________" +
            "KKKKK|    |BB|    |CCCCC" +
            "KKKKK|  __|BB|__  |CCCCC" +
            "KKKKK|  |BBBBBB|  |CCCCC" +
            "KKKKK|  |BBBBBB|  CCCCCC" +
            "KKKKK|  BBBBBBBB   |____" +
            "_|__K|  |BBBBBB|        " +
            "        |B____B|       |" +
            "_                 ______" +
            "|____             IIIIII" +
            "DDDD|___  _____   |IIIII" +
            "DDDDDDD|  |AAA|   |IIIII" +
            "DDDDDDDD  |AAA|   |___I_" +
            "DDDDDDD|  |AAA|        |" +
            "DDDDDDD|  |AAA|   __L__|" +
            "______D|  |AAA|  _|LLLLL" +
            "|         |___|  LLLLLLL" +
            "                 |_LLLLL" +
            "_        __HH__   |____|" +
            "|______  |HHHH|         " +
            "OOOOOOO  |HHHHH        _" +
            "OOOOOO|  |HHHH|  ______|" +
            "OOOOOO|  |HHHH|  SSSSSSS" +
            "OOOOOO|  |HHHH|  |SSSSSS" +
            "OOOOOO| |HHHHHH| |SSSSSS";
  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Board(Cell... allCells)
  {
	  board = new Cell[WIDTH][LENGTH];
  }
  
  public String getBoardString() {
	  return boardString;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Prints the board on the console
   * 
   */
  public void printBoard() {
      String out = "";
      for (int row = 0; row < 25; row++) {
          for (int col = 0; col < 24; col++) {
              char currentChar = boardString.charAt((row * 25) + col);
              out = out.concat(" " + currentChar + " ");
          }
          System.out.println();
          out = out.concat("\n");
      }
      System.out.print(out);
  }

  /**
   * Prints the board on the console, current player as X and other players as .
   */
  public void printBoardWithCurrentPlayer(Player player) {
      String out = "";
      System.out.println();
      
      for (int row = 0; row < 25; row++) {
          for (int col = 0; col < 24; col++) {
              char currentChar = boardString.charAt((row * 24) + col);
              try {
                  Player playerOnBoard = board[col][row].getPlayer(); 
                  if (playerOnBoard.equals(player)) {
                      out = out.concat(" " + 'X' + " ");
                  } else {
                      out = out.concat(" " + '0' + " ");
                  }
              } catch (Exception ex) {
                  out = out.concat(" " + currentChar + " ");
              }
          }

          out = out.concat("\n");
      }
      System.out.print(out);
      System.out.println();
  }
  /**
   * Prints the board on the console, current player as X and other players as .
   * @param rooms An arraylist of all the rooms in the game
   */
  public void populateBoard(ArrayList<Room> rooms) {
      for (int row = 0; row < 25; row++) {
          for (int col = 0; col < 24; col++) {
              char currentChar = boardString.charAt((row * 24) + col);
              Cell currentCell = new Cell(col, row);
              board[col][row] = currentCell;
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

  public Cell[][] getBoard(){
	  return board;
  }

  /* Code from template association_RequiredNumberOfMethod */
  public static int requiredNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfCells()
  {
    return 600;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfCells()
  {
    return 600;
  }

  public void delete()
  {
    board = null;
  }

}
