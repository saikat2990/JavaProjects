package exam1;

public class Student1 {
	

	private String student_name;
	private String registrationID; 
	private String department;
	private String session;
	private String age;
	private String cgpa;
	private String hall;
	
	public Student1() {
		System.out.println("hi");
	}
	
	public Student1(String student_name, String registrationID, String department,String session,String age,String cgpa,String hall) {
		
		this.student_name = student_name;
		this.registrationID = registrationID;
		this.department=department;
		 this.session=session;
		this.age=age;
		this.cgpa=cgpa;
		this.hall=hall;
		
		
	}
	public String getstudent_name() {
		return student_name;
	}
	public String getregistrationID() {
		return registrationID;
	}
	public String getdepartment() {
		return department;
	}
	public int getage() {
		return Integer.parseInt(age);
	}
	
	public double getcgpa() {
		return Double.parseDouble(cgpa);
	}
	
	public String getsession() {
		return session;
	}
	
	public void setage(String age) {
		age =this.age;
	}
	
	public void tostring() {
		System.out.println(student_name+registrationID+department+session+age+cgpa+hall);
	}
	
	public String rakha() {
		String str;
		str = student_name+registrationID+department+session+age+cgpa+hall;
		return str;
	}
	
}
