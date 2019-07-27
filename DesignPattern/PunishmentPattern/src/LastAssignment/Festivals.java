package LastAssignment;

public interface Festivals {
	
	Object Time = null;
	public String getOrganizerName();
	public String getFestivalName();
	public String getFestivalDate();
	public void setObserver(Observer obs);
	public void alamForFest(String festName);
	void broadCastMedia(Mediator m);
	
}
