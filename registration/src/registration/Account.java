package registration;

public class Account {
	
	private double balance;
	private String accName;
	private String password;
	private String email;
	private String gender;
	
	public Account(double balance,String accName,String password,String email,String gender) {
		
		this.balance=balance;
		this.accName=accName;
		this.password=password;
		this.email=email;
		this.gender=gender;
		
		
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public boolean withdraw(double amount) {
		
		if(balance>500) {
			balance-=amount;
			return true;
		}
		else return false;
	}
	
	public  boolean deposit(double amount) {
		
		balance+=amount;
		
		return true;
	}
	
	public String getPassword() {
		
		return password;
	}
	
	public String getAccName() {
		
		return accName;
	}
}
