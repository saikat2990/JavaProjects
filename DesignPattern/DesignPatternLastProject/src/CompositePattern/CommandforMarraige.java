package CompositePattern;

public interface CommandforMarraige {
	public void doMarraige(String person1,String person2);
	public void pressUndo(String person1,String person2);
	public boolean checkCouple(String person1, String person2);
}
