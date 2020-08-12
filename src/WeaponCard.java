


// line 50 "model.ump"
// line 154 "model.ump"
public class WeaponCard extends Card
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------
	private String room;
  //------------------------
  // CONSTRUCTOR
  //------------------------

	  public WeaponCard(String aName, String aroom)
	  {
	    super(aName);
	    room = aroom;
	  }


  //------------------------
  // INTERFACE
  //------------------------
	  /**
	   * Shows movement of weapon when suggestion is made
	   * @param newRoom new weapon room
	   * @return new location of room
	   */
	  public String moveWeapon(String newRoom) {

		  String s = "The " + super.getName() + " moved from " + getRoom() + " to " + newRoom;
		  room = newRoom;
		  return s;
	  }
	    
	  public String getRoom() {
		  return room;
	  }


	  public void delete()
	  {
		  super.delete();
	  }

}