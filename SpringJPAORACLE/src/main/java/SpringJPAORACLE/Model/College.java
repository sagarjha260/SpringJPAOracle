package SpringJPAORACLE.Model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class College 
{
	@Id
	private int collegeId;
	private String collegeName;
	
	
	@OneToMany
	private List<Student> student;
	  
	public List<Student> getStudent() { 
		return student; 
	}
	  
	public void setStudent(List<Student> student) { 
		this.student = student; 
	}
	 
	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
}
