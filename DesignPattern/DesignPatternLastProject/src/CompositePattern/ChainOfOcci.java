package CompositePattern;

public class ChainOfOcci implements ChainOfRes{

	private ChainOfRes next;
	private String condition;
	@Override
	public void nextChain(ChainOfRes cr) {
		// TODO Auto-generated method stub
		next = cr;
	}

	@Override
	public void calculate(int val,String area) {
		// TODO Auto-generated method stub
		if(area.equals("OccidentalPond")) {
			if(val>42) {
				System.out.println("yeah you safe OccidentalPond");
				condition = "yeah you safe OccidentalPond";
			}else {
				System.err.println("pray Occidental people");
				condition = "pray Occidental people";
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
