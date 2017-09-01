package StudentFiles;

import javax.persistence.*;

import java.util.*;

@Entity
public class Student {
	
	@Id
	private int sid;
	private String fname;
	private String lname;
	private String year;
	private String major;
	private double gpa;
	@ManyToMany(mappedBy="student")
	private Collection<Course> course;
	@OneToOne
	private PrivateInformation privateInfo;
	
	public Student() {
		this.course = new LinkedList<>();
	}
	
	public Collection<Course> getCourse() {
		return course;
	}

	public void setCourse(Collection<Course> couse) {
		this.course = couse;
	}
	
	
	public PrivateInformation getPrivateInfo() {
		return privateInfo;
	}

	public void setPrivateInfo(PrivateInformation privateInfo) {
		this.privateInfo = privateInfo;
	}

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
	
	public void setLname(String lname) {
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
	
	
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	public int registeredCredits() {
		int credit = 0;
		for(Course course : this.course) {
			credit += course.getCredit();
		}
		return credit;
	}
	
}
