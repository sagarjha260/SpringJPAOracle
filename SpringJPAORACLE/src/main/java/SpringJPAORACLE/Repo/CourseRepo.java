package SpringJPAORACLE.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringJPAORACLE.Model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>
{

}
