package Model;
//package Java;




public class Accusation
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Accusation Attributes
  private Card[] accusation;
  private Card[] murder;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Accusation(Card[] guess, Card[] murderDeck)
  {
    accusation = guess;
    murder = murderDeck;
  }

  //------------------------
  // INTERFACE
  //------------------------
  /**
   * Compares the accusation with the actual murder
   * @param Player The current player
   * @return The game over value
   */
  public boolean checkAccusation(Player player) {
	  for (int i = 0; i < 3; i++) {
		  if(accusation[i].getName() != murder[i].getName()) {
			  //If they get it wrong they are out
			  player.setPlayerStatus(false);
			  System.out.println("Player " + player.getCharacterCard().getName() + " is out!");
			  return false;
		  }
	  }
	  //otherwise the game is over
	  System.out.println("Player " + player.getCharacterCard().getName() + " wins!");

	  return true;
  }
  			
}