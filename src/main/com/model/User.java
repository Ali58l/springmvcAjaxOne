package model;

public class User {
	int id;
	String fname;
	String lname;
	int accountCout;
	
	public User(int id, String fname, String lname, int accountCout) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.accountCout = accountCout;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAccountCout() {
		return accountCout;
	}

	public void setAccountCout(int accountCout) {
		this.accountCout = accountCout;
	}
	
}
