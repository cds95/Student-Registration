import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	private int sid;
	private String fname;
	private String lname;
	private String year;
	private double gpa;
	
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public int getSid() {
		return this.sid;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setLname(String fname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getYear() {
		return this.year;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
}
