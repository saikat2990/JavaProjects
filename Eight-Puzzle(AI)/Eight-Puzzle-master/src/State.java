/**
 * @file State.java
 * @author Natasha Squires <nsquires@upei.ca>
 * Represents the current state of the board for a particular node
 */
public class State {
	//size of the board
	private final static int BOARD=9;
	//state of the board
	private int[] currentState = new int[BOARD];
	
	/**
	 * @param s
	 * Constructor. Updates state
	 */
	public State(int[] s){
		for(int i=0; i<BOARD; i++){
			currentState[i]=s[i];
		}
	}
	
	/**
	 * @param 
	 * @return int[]
	 * returns current state
	 */
	public int[] getState(){
		return currentState;
	}
	
	/**
	 * @param other
	 * @return boolean
	 * compares two board states for equality
	 */
	public boolean equals(State other){
		int[] otherState = other.getState();
		
		for(int i=0; i<BOARD; i++){
			if(otherState[i]!=currentState[i]){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * @param
	 * @return String
	 * toString method to print out the state
	 */
	public String toString(){
		String result = "";
		for(int i=0; i<BOARD; i++){
			if((i+1)%3==0)
				result += currentState[i] + "\n";
			else
				result += currentState[i] + " ";
		}
		
		return result;
	}
}
