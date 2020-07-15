package SpringJPAORACLE;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import SpringJPAORACLE.Controller.CourseController;
import SpringJPAORACLE.Model.TopicModel;
import SpringJPAORACLE.Service.TopicService;

@AutoConfigureMockMvc
@SpringBootTest(classes = {CourseController.class, TopicService.class, TopicModel.class} ) 
public class SpringJpaoracleApplicationTests {

	@Test
	void contextLoads() {
	}

}
