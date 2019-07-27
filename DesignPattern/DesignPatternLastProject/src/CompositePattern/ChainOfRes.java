package CompositePattern;

public interface ChainOfRes {
	

	public void nextChain(ChainOfRes cr);
	public void calculate(int val,String area);
	public String getCondition();
	
}
