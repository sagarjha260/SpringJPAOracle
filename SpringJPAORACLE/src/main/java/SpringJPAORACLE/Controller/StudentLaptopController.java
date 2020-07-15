package SpringJPAORACLE.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SpringJPAORACLE.Model.College;
import SpringJPAORACLE.Model.Course;
import SpringJPAORACLE.Model.Laptop;
import SpringJPAORACLE.Model.Student;
import SpringJPAORACLE.Repo.CollegeRepo;
import SpringJPAORACLE.Repo.CourseRepo;
import SpringJPAORACLE.Repo.LaptopRepo;
import SpringJPAORACLE.Repo.StudentRepo;

@RestController
public class StudentLaptopController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	LaptopRepo laptopRepo;
	
	@Autowired
	CollegeRepo collegeRepo;
	
	@Autowired
	CourseRepo courseRepo;
	
	@RequestMapping("/insertCourse")
	public void insertCourse() 
	{
		
		Student student1 = new Student();
		student1.setRollno(1);
		student1.setName("Chandler");
		student1.setMarks(80);
		
		Student student2 = new Student();
		student2.setRollno(2);
		student2.setName("Ross");
		student2.setMarks(80);
		
		Course course1 = new Course();
		course1.setCourseID(1);
		course1.setCourseName("Spring Boot");
		
		Course course2 = new Course();
		course2.setCourseID(2);
		course2.setCourseName("Java");
		
		student1.getCourseList().add(course1);
		student1.getCourseList().add(course2);
		
		course1.getStudentList().add(student1);
		course2.getStudentList().add(student1);
		
		course1.getStudentList().add(student2);
		student2.getCourseList().add(course1);
		
		studentRepo.save(student1);
		//courseRepo.save(course2);
	}
	
	@RequestMapping("/insertCollege")
	public void insertCollege() 
	{
		College college = new College();
		college.setCollegeId(3);
		college.setCollegeName("ASET_AMITY");	
		collegeRepo.save(college);
		
		List<Student> student = studentRepo.findAll();
		for(Student s: student) 
		{
			s.setCollege(college);
		}
		
		studentRepo.saveAll(student);
	}
	
	@RequestMapping("/insertStudent")
	public void insertStudent() 
	{
		Laptop laptop= new Laptop();
		laptop.setLid(101);
		laptop.setLname("DELL");
		laptopRepo.save(laptop);
	
		Student student= new Student();
		student.setRollno(2);
		student.setName("Chandler");
		student.setMarks(80);
		student.setLaptop(laptop);
		studentRepo.save(student);
	}
	
	@RequestMapping("/getStudentAndLaptop")
	public Optional<Student> insertLaptop()
	{
		Optional<Student> student = studentRepo.findById(1);
		List<Student> student1 = studentRepo.findAll();
		
		Laptop laptop = student.get().getLaptop();
		System.out.println("-->"+laptop);
		return student;
	}
}
