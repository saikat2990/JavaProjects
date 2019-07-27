package templeteInDesignPattern;

public abstract class MobileOperator {
	
	public double getBill() {
		
		if(checkPeakTime()) {
			return peakTimeBill();
		}else {
			return normalTimeBill();
		}
	}
	
	public abstract boolean checkPeakTime();
	
	public abstract double peakTimeBill();
	
	public abstract double normalTimeBill();
}
