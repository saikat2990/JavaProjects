package CompositePattern;

public class CheckVolume {
	String con="";
	public CheckVolume(int val,String str){
		
		ChainOfRes cOri = new ChainOfOri();
		ChainOfRes cOcci = new ChainOfOcci();
		
		cOri.nextChain(cOcci);
		
		cOri.calculate(val, str);
		
		con=cOri.getCondition();
		
//		if(con.equals("")) {
//			con = cOcci.getCondition();
//		}
		
	}
	
	public String getCondition() {
		return con;
	}
}
