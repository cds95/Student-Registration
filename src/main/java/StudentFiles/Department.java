package StudentFiles;
import javax.persistence.*;
import java.util.*;

@Entity
public class Department {
	
	@Id
	private int did;
	private String departmentName;
	private String handle;
	private String school;
	@OneToMany(mappedBy="department")
	private Collection<Course> courses;
	
	public Department() {
		this.courses = new LinkedList<>();
	}
	
	public Collection<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public void setCourses(Collection<Course> courses) {
		this.courses = courses;
	}

	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
}
