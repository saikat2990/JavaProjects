package LastAssignment;

public class Tv implements Observer{
	
	Festivals fest;
	FestBridge festB;
	
	public Tv(Festivals fest) {
		// TODO Auto-generated constructor stub
		this.fest = fest;
	}

	public Tv(FestBridge fest) {
		// TODO Auto-generated constructor stub
		this.festB = fest;
		System.out.println(observerInfoForBridgeFest());
	}

	@Override
	public String observerName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String observerInfoForDptFest() {
		// TODO Auto-generated method stub
		return fest.getFestivalName()+" "+fest.getFestivalDate()+" "+fest.getOrganizerName()+" "+"From Tv";
	}

	@Override
	public String observerInfoForBridgeFest() {
		// TODO Auto-generated method stub
		return festB.getFestivalName()+" "+festB.festDate()+" "
				+" "+"From Tv"+festB.majorDptName()+" "+festB.subDptName();
	}


}
