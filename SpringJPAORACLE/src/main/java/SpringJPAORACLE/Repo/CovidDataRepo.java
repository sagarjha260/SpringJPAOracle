package SpringJPAORACLE.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SpringJPAORACLE.Model.CovidData;
import SpringJPAORACLE.Model.CovidResult;

@Repository
public interface CovidDataRepo extends JpaRepository<CovidData, Integer>
{
	void save(CovidResult covidResult);		
	
	 @Query(value = "SELECT SCHEMA.CovidData_seq.nextval FROM dual", nativeQuery = true)
	 long getNextValMySequence();
	 
}
