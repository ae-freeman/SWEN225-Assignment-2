

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.0.5092.1e2e91fc6 modeling language!*/

import java.util.*;

public class Player {

//------------------------
	// MEMBER VARIABLES
	// ------------------------

	// Player Attributes
	private boolean playerStatus;

	// Player Associations
	private Cell location;
	private CharacterCard assignedCharacter;
	private ArrayList<Card> playerHand;
	private Scanner scanner = new Scanner(System.in);

	// ------------------------
	// CONSTRUCTOR
	// ------------------------

	public Player(CharacterCard aAssignedCharacter) {
		assignedCharacter = aAssignedCharacter;
		location = assignedCharacter.getStartLocation();
		playerStatus = false;
		playerHand = new ArrayList<Card>();
	}

	// ------------------------
	// INTERFACE
	// ------------------------
	public Player getNextPlayer(Player player, ArrayList<Player> listOfPlayers){
	      // go through list of players to get index of current player
	      int i = 0;
	      while (listOfPlayers.get(i).getCharacterCard() != player.getCharacterCard() && (i+1) < listOfPlayers.size()) {
	          i++;
	      }
	      if(i == listOfPlayers.size() - 1) {
	          return listOfPlayers.get(0);
	      }
	      return listOfPlayers.get(i+1);
	  }


	/**
	 * Checks whether a move is valid
	 *
	 * @param board     being played upon
	 * @param direction to be moved
	 * @return
	 */
	public Cell getTargetCell(Board board, String direction) {
		Cell targetCell = new Cell(0, 0);
		int playerX = location.getXValue();
		int playerY = location.getYValue();
		targetCell = null;

		switch (direction) {
		case "w":
			if (playerY > 0)
				targetCell = board.getBoard()[playerX][playerY - 1];
			break;
		case "a":
			if (playerX > 0)
				targetCell = board.getBoard()[playerX - 1][playerY];
			break;
		case "s":
			if (playerY < 24)
				targetCell = board.getBoard()[playerX][playerY + 1];
			break;
		case "d":
			if (playerX < 23)
				targetCell = board.getBoard()[playerX + 1][playerY];
			break;
		default:
			targetCell = null;
		}

		return targetCell;

	}

	/**
	 * Moves player along board in direction specified by user
	 *
	 * @param numMoves number of times player can move
	 * @param board    board being played upon
	 */
	public void movePlayer(int numMoves, Board board) {

		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		// If the player is in a room they can either move to another door or stay and
		// make an accusation
		if (this.getCell().getRoom().getName() != "Hallway") {
			System.out.println("Would you like to stay in the " + getRoom() + " and make an accusation/suggestion?");
			System.out.println("Press 1 to make an accusation or suggestion\n" + "Press 2 to move\n");
			do {
				System.out.println("Please enter 1 or 2");

				try {
					choice = scanner.nextInt();
					if (choice == 1 || choice == 2) {
						break;
					} else {
						System.out.println("Please enter either 1 or 2");
						scanner.next();
						continue;
					}
				} catch (final InputMismatchException e) {
					System.out.println("You have entered an invalid input. Try again.");
					scanner.next(); // discard non-integer input
					continue; // restart loop, didn't get an integer input
				}
			} while (true);

			// if they choose to leave return true
			if (choice == 1) {
				return;
			}
			// If they choose to leave run the move method
			if (choice == 2) {
				move(numMoves, board);
			}
		} else {
			move(numMoves, board);
		}
		return;
	}

	/**
	 * Moves the player numMoves "steps"
	 * @param numMoves number of steps to move
	 * @param board current game board
	 */
	public void move(int numMoves, Board board) {
		// ArrayList to keep track of where the player has moved during that turn
		ArrayList<Cell> trackedMoves = new ArrayList<Cell>();
		trackedMoves.add(board.getBoard()[getCell().getXValue()][getCell().getYValue()]);
		Cell targetCell = null;
		String direction = "";
		// Whether to ask for direction from user
		boolean getDirectionFromUser = true;

		while (numMoves > 0) {
			board.printBoardWithCurrentPlayer(this);

			// If need to ask direction from user
			if (getDirectionFromUser) {
				// get direction of moves
				System.out.println("You have: " + numMoves + " moves remaining. ");
				System.out.println("Enter w to move up, s to move down, a to move left and d to move right:");
				System.out.println("Or enter q to end turn:");
				direction = scanner.nextLine();
			}

			// if valid direction entered get old and target cells
			if(direction.equals("q")) {
				numMoves = 0;
			}
			if ((direction.equals("w") || direction.equals("a") || direction.equals("s") || direction.equals("d"))) {
				Cell oldCell = getCell();
				//if the move is out of the board or they have already moved there
				if (getTargetCell(board, direction) == null
						|| trackedMoves.contains(getTargetCell(board, direction))) {
					System.out.print("Invalid move, please try again.");
				}
				// if you can move to that cell change player location and update cells
				else {
					targetCell = getTargetCell(board, direction);
					// If target cell is empty and not a wall
					if (targetCell.getIsAccessible()) {
						// Remove the player from previous cell if old cell is the current location
						if (oldCell.getPlayer().equals(this)) {
							oldCell.setPlayer(null);
							oldCell.setIsAccessible(true);
						}
						// Set player to target cell
						setLocation(targetCell);
						targetCell.setIsAccessible(false);
						targetCell.setPlayer(this);
						trackedMoves.add(targetCell);
						// Recalculate num of moves remaining
						numMoves = calculateNumMoves(numMoves, oldCell, targetCell, trackedMoves);

						// Now need to get user input for next move
						getDirectionFromUser = true;

					} else if (!(targetCell.getPlayer() == (null))) {
						// Else if target cell contains player when trying to enter a room
						if (!(targetCell.getPlayer().getRoom().equals("Hallway"))) {
							// Clear current player from previous cell if necessary
							if (oldCell.getPlayer().equals(this)) {
								oldCell.setPlayer(null);
								oldCell.setIsAccessible(true);
							}
							setLocation(targetCell);
							// Don't need to get direction from user as we will "jump"
							// the player in our way when trying to enter room
							getDirectionFromUser = false;
						}
					}
				}
			}
		}
		board.printBoardWithCurrentPlayer(this);
	}

	/**
	 * Calculates new number of remaining moves
	 * @param numMoves current number of moves remaining
	 * @param targetCell destination cell
	 * @param trackedMoves cells visited so far in turn
	 */
	public int calculateNumMoves(int numMoves, Cell oldCell, Cell targetCell, ArrayList<Cell> trackedMoves) {
		// If you've been to the hallway at all during your turn
		// and you have arrived to a room then your turn is now over
		if(!(targetCell.getRoom().getName().equals("Hallway")) && hasBeenToHallway(trackedMoves)) {
			numMoves = 0;
			System.out.println("You are currently in the " + getCell().getRoom().getName());
		//if they are moving out of a room or in a hallway subtract a move
		} else if (!(oldCell.getRoom().getName().equals(targetCell.getRoom().getName()))
					|| targetCell.getRoom().getName().equals("Hallway")){

			numMoves -= 1;

		}
		return numMoves;
	}

	/**
	 * Checks if player has been to hallway during turn
	 * @param trackedMoves all cells visited in turn
	 * @return
	 */
	public boolean hasBeenToHallway(ArrayList<Cell> trackedMoves) {
		for (int i = 0; i < trackedMoves.size(); i++) {
			if (trackedMoves.get(i).getRoom().getName().equals("Hallway")) {
				return true;
			}
		}
		return false;
	}

	public String getRoom() {
		return getCell().getRoom().getName();
	}

	public void addToHand(Card card) {
		playerHand.add(card);
	}

	public int move(int roll) {
		return roll;
	}

	public boolean setLocation(Cell aLocation) {
		boolean wasSet = false;
		location = aLocation;
		wasSet = true;
		return wasSet;
	}

	public boolean setPlayerStatus(boolean aPlayerStatus) {
		boolean wasSet = false;
		playerStatus = aPlayerStatus;
		wasSet = true;
		return wasSet;
	}

	public boolean getPlayerStatus() {
		return playerStatus;
	}

	/* Code from template attribute_IsBoolean */
	public boolean isPlayerStatus() {
		return playerStatus;
	}

	/* Code from template association_GetOne */
	public Cell getCell() {
		return location;
	}

	/* Code from template association_GetOne */
	public CharacterCard getCharacterCard() {
		return assignedCharacter;
	}

	/* Code from template association_GetMany */
	public Card getCard(int index) {
		Card aCard = playerHand.get(index);
		return aCard;
	}
	public ArrayList<Card> getHand() {
	return playerHand;
	}
	public void printHand() {
		System.out.println("Your hand:\n");
		for (int l = 0; l < playerHand.size(); l++) {
			System.out.println(playerHand.get(l).getName());
		}
	}

	public int numberOfCards() {
		int number = playerHand.size();
		return number;
	}

	public boolean hasCards() {
		boolean has = playerHand.size() > 0;
		return has;
	}

	/* Code from template association_SetUnidirectionalOne */
	public boolean setCell(Cell aNewCell) {
		boolean wasSet = false;
		if (aNewCell != null) {
			location = aNewCell;
			wasSet = true;
		}
		return wasSet;
	}

	/* Code from template association_SetUnidirectionalOne */
	public boolean setCharacterCard(CharacterCard aNewCharacterCard) {
		boolean wasSet = false;
		if (aNewCharacterCard != null) {
			assignedCharacter = aNewCharacterCard;
			wasSet = true;
		}
		return wasSet;
	}

	/* Code from template association_MinimumNumberOfMethod */
	public static int minimumNumberOfCards() {
		return 3;
	}

	/* Code from template association_MaximumNumberOfMethod */
	public static int maximumNumberOfCards() {
		return 6;
	}

	public String toString() {
		return super.toString() + "[" + "playerStatus" + ":" + getPlayerStatus() + "]"
				+ System.getProperties().getProperty("line.separator") + "  " + "cell = "
				+ (getCell() != null ? Integer.toHexString(System.identityHashCode(getCell())) : "null")
				+ System.getProperties().getProperty("line.separator") + "  " + "characterCard = "
				+ (getCharacterCard() != null ? Integer.toHexString(System.identityHashCode(getCharacterCard()))
						: "null");
	}
}
