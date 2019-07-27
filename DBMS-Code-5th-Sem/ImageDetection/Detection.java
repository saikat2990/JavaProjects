package ImageDitection;

public class Detection {
	
	public int skin;
	public int nonSkin;
	double probability; 
	
	public Detection() {
		// TODO Auto-generated constructor stub
		this.skin=0;
		this.nonSkin=0;
	}
	void setSkin(int n) {
		skin+=n;
	}
	int getSkin() {
		return skin;
	}
	void setnonSkin(int n) {
		nonSkin+=n;
	}
	int getnonSkin() {
		return nonSkin;
	}
	double getProbability() {
		return ((double)skin/(double)nonSkin);
	}
}
