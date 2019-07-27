package Image;

public class Detection {
	
	public int skin;
	public int nonSkin;
	double probability; 
	
	public Detection() {
		// TODO Auto-generated constructor stub
		this.skin=0;
		this.nonSkin=0;
	}
	public void setSkin(int n) {
		skin+=n;
	}
	public int getSkin() {
		return skin;
	}
	public void setnonSkin(int n) {
		nonSkin+=n;
	}
	public int getnonSkin() {
		return nonSkin;
	}
	public double getProbability() {
		return ((double)skin/(double)nonSkin);
	}

}
