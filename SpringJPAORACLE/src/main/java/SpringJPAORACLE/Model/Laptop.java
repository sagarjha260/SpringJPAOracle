package SpringJPAORACLE.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Laptop {
	
	@Id
	private int lid;
	private String lname;
	
	@OneToOne  //This is to reverse mapping, forign key(rollno) should be there in Laptop Entity and will have to update rollno foreign key also in LAptop entity.
	private Student student;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
}
