package LastAssignment;

public class CseMathBridge implements FestBridge{

	Festivals major;
	Festivals minor;
	String ObserverName;
	
	public CseMathBridge(Festivals major,Festivals minor,String ObserverName){

		this.major=major;
		this.minor=minor;
		this.ObserverName=ObserverName;
		System.out.println("hey i am in csemathbridge");
	}
	
	
	@Override
	public String majorDptName() {
		// TODO Auto-generated method stub
		return major.getOrganizerName();
	}
	
	public void broadCastMedia(Mediator m) {
		// TODO Auto-generated method stub
		m.setFestBridgeObserver(this, ObserverName);
	}
	
	@Override
	public String subDptName() {
		// TODO Auto-generated method stub
		return minor.getOrganizerName();
	}

	@Override
	public String festDate() {
		// TODO Auto-generated method stub
		return major.getFestivalDate();
	}

	@Override
	public String getObserverName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setObserver(Observer observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alamForFest(String festName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFestivalName() {
		// TODO Auto-generated method stub
		return major.getFestivalName();
	}

}
