package lab2;

public class Student {
	
	private String reg;
	private String name;
	private String dept;
	private String age;
	private String session;
	
	public Student() {
		System.out.println("hi");
	}
	
	public Student(String reg, String name, String dept, String age, String session) {
		
		this.reg = reg;
		this.name=name;
		this.dept=dept;
		 this.age=age;
		this.session=session;
		
		
	}
	public String getname() {
		return name;
	}
	public String getreg() {
		return reg;
	}
	public String getdept() {
		return dept;
	}
	public int getage() {
		return Integer.parseInt(age);
	}
	public void setage(String age) {
		age =this.age;
	}
	public String getsession() {
		return session;
	}
	
	public void tostring() {
		
		System.out.println(reg+" "+name+" "+dept+" "+age+" "+session);
		
	}
	
	public int  copareTo(String stu1age,String stu2age) {
		
		return stu1age.compareTo(stu2age);
	}
	
}
