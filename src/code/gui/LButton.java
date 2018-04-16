package code.gui;

import javax.swing.JButton;

import code.Location;



/**
 * Different form of JButton
 * @author Eric Weinman
 *
 */
class LButton extends JButton {

	public LButton() {
		super();
	}

	public LButton(Location l) {
		super();
		set_location(l);
	}

	public LButton(String s, Location l) {
		super(s);
		set_location(l);
	}

	public LButton(String s) {
		super(s);
	}

	private static final long serialVersionUID = 1L;
	private Location _location;
	private String ID;
	/**
	 * @return the _location
	 */
	public Location get_location() {
		return _location;
	}
	/**
	 * @param _location the _location to set
	 */
	public void set_location(Location _location) {
		this._location = _location;
	}
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}		
}