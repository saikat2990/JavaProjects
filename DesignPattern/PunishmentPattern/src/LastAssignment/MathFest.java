package LastAssignment;

public class MathFest implements Festivals{
	Observer observer;
	String festName;
	String time;
	String ObserverName;
	String OrganizerName;
	
	public MathFest(String festName,String time,String ObserverName,String OrganizerName){
		this.festName = festName;
		this.time = time;
		this.ObserverName = ObserverName;
	}
	
	
	
	@Override
	public String getOrganizerName() {
		// TODO Auto-generated method stub
		return OrganizerName;
	}

	@Override
	public String getFestivalName() {
		// TODO Auto-generated method stub
		return festName;
	}


	@Override
	public String getFestivalDate() {
		// TODO Auto-generated method stub
		return time;
	}

	@Override
	public void broadCastMedia(Mediator m) {
		// TODO Auto-generated method stub
		m.setFestObserver(this, ObserverName);
	}

	@Override
	public void setObserver(Observer obs) {
		// TODO Auto-generated method stub
		observer = obs;

	}

	@Override
	public void alamForFest(String festName) {
		// TODO Auto-generated method stub
		System.out.println("Now its time for the fest which name "+festName);
	}

}
