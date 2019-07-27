package CompositePattern;

public class ChainOfOri implements ChainOfRes{

	private ChainOfRes next;
	String condition;
	@Override
	public void nextChain(ChainOfRes cr) {
		// TODO Auto-generated method stub
		next = cr;
	}

	@Override
	public void calculate(int val,String area) {
		// TODO Auto-generated method stub
		if(area.equals("OrientalPond")) {
			
			if(val>42) {
				System.out.println("yeah you safe OrientalPond");
				condition = "yeah you safe OrientalPond";
			}else {
				System.err.println("pray Oriental people");
				condition = "pray Oriental people";
			}
			
		}else {
			
			next.calculate(val, area);
		}
		
	}

	@Override
	public String getCondition() {
		// TODO Auto-generated method stub
		return condition;
	}
	
	

}
