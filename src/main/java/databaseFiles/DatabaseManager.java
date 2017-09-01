package databaseFiles;
import java.util.List;

import StudentFiles.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DatabaseManager {
	
	private Configuration con;
	private SessionFactory sessionFact;
	private Session session;
	
	/**
	 * Creates a new instance of the DatabaseManager by making a connection to MySQL Database
	 */
	public DatabaseManager() {
		this.con = new Configuration().configure();
		this.con.addAnnotatedClass(Student.class);
		this.con.addAnnotatedClass(Course.class);
		this.con.addAnnotatedClass(PrivateInformation.class);
		this.con.addAnnotatedClass(Department.class);
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        this.sessionFact = con.buildSessionFactory(reg);
        this.session = this.sessionFact.openSession();
	}
	
	/**
	 * Get department information
	 * @param did
	 * @return
	 */
	public Department getDepartment(int did) {
		String hql = "From Department WHERE did = :did";
		Query query = this.session.createQuery(hql);
		query.setParameter("did", did);
		List<Department> depts = query.list();
		return depts.get(0);
	}
	
	/**
	 * Get department information
	 * @param did
	 * @return
	 */
	public Department getDepartment(String departmentName) {
		String hql = "From Department WHERE departmentName = :name";
		Query query = this.session.createQuery(hql);
		query.setParameter("name", departmentName);
		List<Department> depts = query.list();
		return depts.get(0);
	}
	
	/**
	 * Adds a student into the database
	 * @param student
	 */
	public void addUser(Student student) {
		Transaction tx = session.beginTransaction();
		this.session.save(student);
		tx.commit();	
	}
	
	/**
	 * Registers a student to a class.  Returns true if student successfully registered,
	 * and false otherwise.
	 * @param student
	 */
	public boolean registerUser(Student student, Course course) {
		if(student.registeredCredits() + course.getCredit() < 20 && !course.containsStudent(student) && !course.isFull()) {
			student.getCourse().add(course);
			course.getStudent().add(student);
			Transaction tx = session.beginTransaction();
			this.session.update(student);
			this.session.update(course);
			tx.commit();	
			return true;
		}
		return false;
	}
	
	/**
	 * Registers a student to a class
	 * @param student
	 */
	public void addClassToDepartment(Department department, Course course) {
		department.getCourses().add(course);
		course.setDepartment(department);
		Transaction tx = session.beginTransaction();
		this.session.update(department);
		this.session.update(course);
		tx.commit();	
	}
	/**
	 * Removes a student from a given class
	 * @param student
	 */
	public void removeClass(Student student, Course course) {
		student.getCourse().remove(course);
		course.getStudent().remove(student);
		Transaction tx = session.beginTransaction();
		this.session.update(student);
		this.session.update(course);
		tx.commit();	
	}
	
	/**
	 * Gets a users private information
	 * @param sid
	 * @return
	 */
	public PrivateInformation getCredentials(String username) {
		String hql = "From PrivateInformation Where username = :username";
		Query query = this.session.createQuery(hql);
		query.setParameter("username", username);
		return (PrivateInformation) query.list().get(0);
	}
	
	
	/**
	 * Gets student
	 * @param sid
	 * @return
	 */
	public Student getStudent(int sid) {
		String hql = "From Student Where sid = :sid";
		Query query = this.session.createQuery(hql);
		query.setParameter("sid", sid);
		List<Student> list = query.list();
		return list.get(0);
	}
	
	/**
	 * Gets Course
	 * @param sid
	 * @return
	 */
	public Course getCourse(int cid) {
		String hql = "From Course Where cid = :cid";
		Query query = this.session.createQuery(hql);
		query.setParameter("cid", cid);
		List<Course> list = query.list();
		return list.get(0);
	}
	
	/**
	 * Returns all the students in the table
	 * @return
	 */
	public List<Student> getAllStudents() {
		String hql = "From Student";
		Query query = this.session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> list = query.list();
		return list;
	}
	
	/**
	 * Ends a session
	 */
	public void endSession() {
		this.sessionFact.close();
	}
}
