package StudentFiles;

import javax.persistence.*;

@Entity
@Table(name="Privacy")
public class PrivateInformation {
	
	@Id
	private int sid;
	private String username;
	private String password;
	@OneToOne
	private Student student;
	
	public int getSid() {
		return sid;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
