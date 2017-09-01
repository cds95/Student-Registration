package StudentFiles;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="Course")
public class Course {
	
	@Id
	private int cid;
	private String instructor;
	@Column(name="description")
	private String name;
	@Column(name="courseNum")
	private int number;
	private int credit;
	@ManyToOne
	private Department department;
	@ManyToMany
	private Collection<Student> student;
	private int capacity;
	
	public Course() {
		this.student = new LinkedList<>();
	}
	public int size() {
		return this.student.size();
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Collection<Student> getStudent() {
		return student;
	}
	public void setStudent(Collection<Student> student) {
		this.student = student;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public boolean containsStudent(Student stud) {
		return this.student.contains(stud);
	}
	public boolean isFull() {
		return this.size() >= this.capacity;
	}
		
}
