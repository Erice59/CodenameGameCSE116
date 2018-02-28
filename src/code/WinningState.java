package code;

public class WinningState {

	boolean win;
	
	
	
	/* 
	 * Takes in a person and if it's assassin and it's revaled, returns true
	 * @param A person
	 * @returns a val, true or false depending if is a winning state
	 */
	public boolean assasinRevealed(Location l){
		
		//if p is an assasin and it's revealed... need a method to determine if p is revealed
		if (l.get_person().equals("Assasin") && l.is_revealed()){
			win = true;
		}
		
		else{
			win = false;
		}
			return win;
	}
	
	/*
	 * Takes in a number of red agents revealed, returns bool val if 9 were revealed
	 * @param number of red agents revealed
	 * @returns a val, true or false depending if is a winning state
	 * @pre req: numberRevealed has to be positive
	 */
	public boolean redAgentRevealed(int numberRevealed){
		if (numberRevealed == 9){
			win = true;
		}
		else{
			win = false;
		}
		return win;
	}
	
	/*
	 * Takes in a number of blue agents revealed, returns bool val if 8 were revealed
	 * @param number of blue agents revealed
	 * @returns a val, true or false depending if is a winning state
	 */
	public boolean blueAgentRevealed(int numberRevealed){
		if (numberRevealed == 8){
			win = true;
		}
		else{
			win = false;
		}
		return win;
	}
}

