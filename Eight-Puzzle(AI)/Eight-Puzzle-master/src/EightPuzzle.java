/**
 * @file EightPuzzle.java
 * @author Natasha Squires <nsquires@upei.ca>
 * AI program to solve the 8 puzzle
 */
public class EightPuzzle {
  public static void main(String[] args){
	  System.out.println("Manhattan distance:");
	  AStar search = new AStar(1);//manhattan distance
	  search.AStarSearch();
	  
	 System.out.println("Hamming distance:");
	  AStar search2 = new AStar(0);
	  search2.AStarSearch();
  }
}
