package CompositePattern;

public class OrientalEnvirnment implements Envirment {

	private OrientalEnvirnment oriEnvir;
	
	public OrientalEnvirnment OriEnvir;
	public OrientalEnvirnment getIntance() {
		OriEnvir=oriEnvir;
		return OriEnvir;
	}
	
	String condition="";
	OrientalMainDraw orientalMainDraw;
	public OrientalEnvirnment(){
		
		orientalMainDraw = new OrientalMainDraw();
		
	}
	
	public String getCondition() {
		condition = orientalMainDraw.condition;
		return condition;
	}
	
	
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
