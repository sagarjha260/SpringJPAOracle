package SpringJPAORACLE.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringJPAORACLE.Model.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer>
{ 
	

}
