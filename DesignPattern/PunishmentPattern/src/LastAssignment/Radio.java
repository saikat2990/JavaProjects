package LastAssignment;

public class Radio implements Observer{

	Festivals fest;
	FestBridge festB;
	public Radio(Festivals fest) {
		// TODO Auto-generated constructor stub
		this.fest=fest;
		System.out.println(observerInfoForDptFest());
	}

	public Radio(FestBridge festB) {
		// TODO Auto-generated constructor stub
		this.festB = festB;
		System.out.println( observerInfoForBridgeFest());
	}

	@Override
	public String observerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String observerInfoForDptFest() {
		// TODO Auto-generated method stub
		return fest.getFestivalName()+" "+fest.getFestivalDate()+" "+fest.getOrganizerName()+" "+"From Radio";
	}

	@Override
	public String observerInfoForBridgeFest() {
		// TODO Auto-generated method stub
		return festB.getFestivalName()+" "+festB.festDate()+" "+" "+"From Radio";
	}

}
