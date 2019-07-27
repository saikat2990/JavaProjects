package LastAssignment;

public class IITCSEBridge implements FestBridge{

	Festivals major;
	Festivals minor;
	String ObserverName;
	
	IITCSEBridge(Festivals major,Festivals minor,String ObserverName){

		this.major=major;
		this.minor=minor;
		this.ObserverName=ObserverName;
		
	}
	
	
	@Override
	public String majorDptName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void broadCastMedia(Mediator m) {
		// TODO Auto-generated method stub
		m.setFestBridgeObserver(this, ObserverName);
	}
	
	@Override
	public String subDptName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String festDate() {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

}
