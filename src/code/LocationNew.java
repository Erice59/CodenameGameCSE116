package code;

/**
 * Class for location instances. Each instance contains if that location is revealed or not, the person type, associated codename,
 * and an "id" assigned from the location in the array.
 * @author Eric Weinman
 *
 */

public class LocationNew {

	/**
	 * Boolean of if this location instance is revealed or not.
	 */
	private boolean _revealed;
	/**
	 * The person type associated at this location (Red/Blue agent, Assassin, or Bystander).
	 */
	private PeopleTypes _person;
	/**
	 * The codename associated at this location instance.
	 */
	private String _codename;
	/**
	 * The "id" given from the board location.
	 */
	private String _id;

	/**
	 * Constructor for location instance. By default _person, _codename, and _id are null for the object, but _revealed is set to false.
	 */
	public LocationNew() {
		set_revealed(false);
	}
	/**
	 * Full constructor that builds each location instance without the need to set each instance variable manually.
	 * @param person Type of person at this location. Either Red agent, Blue agent, Assassin, or Bystander.
	 * @param codename The codename for this location.
	 * @param id The id assigned for the location in the board.
	 */
	public LocationNew(PeopleTypes person, String codename, String id) {
		set_revealed(false);
		set_person(person);
		set_codename(codename);
		set_id(id);
	}
	/**
	 *
	 * @return Current status of if the location is revealed as a boolean, true for yes and false for no.
	 */
	public boolean is_revealed() {
		return _revealed;
	}
	/**
	 * 
	 * @param _revealed Manual adjustment to state of if the location is revealed or not.
	 */
	public void set_revealed(boolean _revealed) {
		this._revealed = _revealed;
	}
	/**
	 * 
	 * @return Person type associated with this location a string of "Red", "Blue", "Bystander", or "Assassin".
	 */
	public PeopleTypes get_person() {
		return _person;
	}
	/**
	 * 
	 * @param _person Manual adjustment to type of person, should be set to a string of "Red", "Blue", "Bystander", or "Assassin".
	 */
	public void set_person(PeopleTypes _person) {
		this._person = _person;
	}
	/**
	 * 
	 * @return Codename associated with this location, a string.
	 */
	public String get_codename() {
		return _codename;
	}
	/**
	 * 
	 * @param _codename Manual adjustment or setting of codename, should be from the master codename list.
	 */
	public void set_codename(String _codename) {
		this._codename = _codename;
	}
	/**
	 * 
	 * @return Arbitrary id based on location in the board of this location instance.
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * 
	 * @param _id ID of point in board to be set.
	 */
	public void set_id(String _id) {
		this._id = _id;
	}



}
