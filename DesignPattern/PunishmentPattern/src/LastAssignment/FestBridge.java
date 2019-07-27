package LastAssignment;

public interface FestBridge {
	
	String Time = null;
	public String majorDptName();
	public String subDptName();
	public String festDate();
	public String getObserverName();
	public void setObserver(Observer observer);
	public void alamForFest(String festName);
	public String getFestivalName();
	public void broadCastMedia(Mediator m);
	
}
