package SpringJPAORACLE.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringJPAORACLE.Model.College;
import SpringJPAORACLE.Model.Student;

public interface CollegeRepo extends JpaRepository<College, Integer>
{
	
}
