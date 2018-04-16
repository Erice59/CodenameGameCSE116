<<<<<<< HEAD
//package code.gui;
//
//import code.Clue;
//import code.GameStart;
//
///**
// * The entire turn is called here through method calls of other classes
// * @author Alex Chmielewski
// *
// */
//public class Turn extends GuiConnector{
//	/**
//	 * instance of gamestart
//	 */
//	private GameStart gs;
//	private Clue c;
//	private Spy
//	public Turn(GameStart gs, Clue c){
//		this.gs = gs;
//		this.c = c;
//	}
//	
//	public void wholeTurn() {
//		spy = new SpymasTurn(gs, c);
////		spy.clueEnter();
////		spy.countEnter();
////		spy.turnPopup();
//	}
//}
=======
package code.gui;

import code.Clue;
import code.GameStart;

/**
 * The entire turn is called here through method calls of other classes
 * @author Alex Chmielewski
 *
 */
public class Turn {
	private TeamTurn team;
	private GameStart gs;
	private Clue c;
	private SpymasTurn spy;
	
	public Turn(GameStart gs, Clue c){
		this.gs = gs;
		this.c = c;
	}
	
	public void wholeTurn() {
		spy = new SpymasTurn(gs, c);
//		spy.clueEnter();
//		spy.countEnter();
//		spy.turnPopup();
	}
}
>>>>>>> branch 'master' of https://github.com/CSE116-Spring2018/s18semesterproject-a6-theprimitivetypes.git
