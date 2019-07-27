package labfinal;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Line l = new Line("SAIKAT SEN");
		System.out.println(l.compareToString("suikat"));
		
		
		
		//if(l.startsWith("sai"))System.out.println("1");
		
		/*if(l.endsWith("sai")) {
			System.out.println("1");
		}*/
		
		//l.replace("saikat", "sai");
		//System.out.println(l.indexOf('a'));
		
		l.toLowerCase();
		l.toUpperCase();
		l.findPosition("aik");
	}

}
