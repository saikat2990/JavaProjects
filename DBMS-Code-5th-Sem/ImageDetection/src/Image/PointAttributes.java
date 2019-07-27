package Image;

public class PointAttributes {
	public int rr1;
	public int gg;
	public int bb;
	public int skin=0;
	public int nonSkin=0;
	double probability; 
	
	
	public PointAttributes(int rr1,int gg,int bb) {
		// TODO Auto-generated constructor stub
		this.rr1 = rr1;
		this.gg=gg;
		this.bb=bb;
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
	int getgg() {
		return gg;
	}
	int getbb() {
		return bb;
	}
	int getrr() {
		return rr1;
	}
	
}
