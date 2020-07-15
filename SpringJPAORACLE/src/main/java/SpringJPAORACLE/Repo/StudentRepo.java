package SpringJPAORACLE.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringJPAORACLE.Model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>
{

}
