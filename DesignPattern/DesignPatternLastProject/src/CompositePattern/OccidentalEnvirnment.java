package CompositePattern;

public class OccidentalEnvirnment implements Envirment {
	
	//singleTon
	private OccidentalEnvirnment occiEnvir;
	
	public OccidentalEnvirnment OcciEnvir;
	public OccidentalEnvirnment getIntance() {
		OcciEnvir=occiEnvir;
		return OcciEnvir;
	}
	
	String condition="";
	OccidentalMainDraw occidentalMainDraw;
	public OccidentalEnvirnment() {
		
		occidentalMainDraw = new OccidentalMainDraw();
		
	}
	
	public String getCondition() {
		condition = occidentalMainDraw.condition;
		return condition;
	}
	@Override
	public void selectFlora() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectFouna() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void selectHutBuilder() {
		// TODO Auto-generated method stub
		
	}
}
