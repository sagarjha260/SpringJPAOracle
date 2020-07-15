package SpringJPAORACLE.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int rollno;
	private String name;
	private int marks;
	
	@OneToOne 
	@JoinColumn(name="laptop_id", referencedColumnName="lid")
	private Laptop laptop; //We have to specify the relationship between Student and Laptop that is why we have used @OneToOne
	
	@ManyToOne        //Foreign Key field will always be created in Many side(here college_id field must be in Student Entity).
	@JoinColumn(name="college_id", referencedColumnName="collegeId")
    private College college;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL ) //"cascade=CascadeType.All" means this will Update/Delete child attribute whenever parent entity get deleted and updated 
	@JoinTable(name="student_courses",
		joinColumns = { @JoinColumn(name = "student_rollno")},
		inverseJoinColumns = { @JoinColumn ( name ="course_courseID")})
	List<Course> courseList = new ArrayList<Course>();
	

	public List<Course> getCourseList() {
		return courseList;
	}
	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	public College getCollege() {
		return college;
	}
	public void setCollege(College college) {
		this.college = college;
	}
}
