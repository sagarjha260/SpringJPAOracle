package SpringJPAORACLE.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import SpringJPAORACLE.Model.TopicModel;

@Repository
public interface TopicRepository extends JpaRepository<TopicModel, String>{
	
	 @Query(value = "SELECT * FROM TopicModels t WHERE t.name = 'Java' ",nativeQuery=true)
	 public TopicModel findByName();


}
