package code;

public class Person {
	private String identity;
	private boolean isRevealed; //bool to determine if person has been revealed or not
	
	public Person(String id) {
		identity = id;
		isRevealed = false;
		
	}
	public void setIdentity(String id) {
		this.identity = id;
	}
	
	public String getIdentity() {
		return this.identity;
	}
	
	public void setRevealed(boolean revealed){
		this.isRevealed = revealed;
	}
	
	public boolean getRevealed(){
		return isRevealed;
	}
}
