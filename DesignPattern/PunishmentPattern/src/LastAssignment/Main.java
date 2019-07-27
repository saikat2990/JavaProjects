package LastAssignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Festivals cseProgramming = new CseFestivals("Programming", "2016/11/16 12:08:43", "Radio", "Rakib");
		
//		Tsc tsc = new Tsc();  
//		tsc = tsc.getIntance();
		
		Mediator m = new Mediator();
//		cseProgramming.broadCastMedia(m);
//		
//		
		FestBridge matholympaid = new CseMathBridge(new CseFestivals("Programming", "2016/11/17 12:08:44", "Tv", "Rakib"),
				new MathFest("Programming", "2016/11/17 12:08:44", "Tv", "Rabbi"),"Tv");
//		
//		fb.broadCastMedia(m);
		
		//m.setFestObserver(cseProgramming, "Programming");
		
		Tsc tsc = Tsc.getInstance();
		String tm ="2016/11/16 12:08:44";
		String tm1 ="2016/11/17 12:08:44";
		
		
		if(tsc.isFree(tm)) {
			cseProgramming.broadCastMedia(m);
			//m.setFestObserver(cseProgramming, "Programming");
			
		}else {
			System.out.println("Cannot create a fest");
		}
		
		if(tsc.isFree(tm1)) {
			matholympaid.broadCastMedia(m);
			//m.setFestObserver(cseProgramming, "Programming");
			
		}else {
			System.out.println("Cannot create a fest");
		}
		
		
	}

}
