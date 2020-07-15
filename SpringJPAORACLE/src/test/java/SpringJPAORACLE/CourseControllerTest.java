package SpringJPAORACLE;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.json.JSONArray;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;

import SpringJPAORACLE.Controller.CourseController;
import SpringJPAORACLE.Model.TopicModel;
import SpringJPAORACLE.Repo.TopicRepository;
import SpringJPAORACLE.Service.TopicService;

@AutoConfigureMockMvc
@SpringBootTest(classes = {CourseController.class, TopicService.class, TopicModel.class})
public class CourseControllerTest extends SpringJpaoracleApplicationTests
{
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private TopicService tserv;
	
	@Autowired
	private CourseController courseController;
	
	@MockBean
	private TopicRepository topicRepository;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void testGetAllTopics() throws Exception 
	{
		List<TopicModel> listTopicModel = new ArrayList<>(); 
		
		TopicModel t= new TopicModel();
		t.setId("100");
		t.setName("Java");
		t.setDescription("Learning Java");
		
		TopicModel t1= new TopicModel();
		t1.setId("101");
		t1.setName("Spring");
		t1.setDescription("Learning Spring");
		
		listTopicModel.add(t);
		listTopicModel.add(t1);
		
		Mockito.when( tserv.getAllTopics()) .thenReturn(Arrays.asList(t, t1)); //topicRepository.findAll())
		
		List<TopicModel> topicModelList = courseController.getAllTopics();
		 
        assertThat(topicModelList.size()).isEqualTo(2);
        assertThat(topicModelList.get(0).getName()).isEqualTo(t.getName());
        assertThat(topicModelList.get(1).getName()).isEqualTo(t1.getName());
	
	}
	
	@Test
	public void testGetTopic() throws Exception 
	{
		TopicModel t= new TopicModel();
		t.setId("100");
		t.setName("Java");
		t.setDescription("Learning Java");
		
		Mockito.when( tserv.getTopic("100")).thenReturn(Optional.of(t)); //topicRepository.findAll())
		
		Optional<TopicModel> topicModel = courseController.getTopic("100");
		 
        assertThat(topicModel.get().getName()).isEqualTo("Java");
        assertThat(topicModel.equals(t));
	}
	
	@Test
	public void testAddTopic() throws Exception 
	{
		TopicModel t= new TopicModel();
		t.setId("105");
		t.setName("Javaa");
		t.setDescription("Learning Javaa");
		
		courseController.addTopic(t);
		
		//Mockito.when( tserv.getTopic("105")).thenReturn(Optional.of(t)); //topicRepository.findAll())
		
		//Optional<TopicModel> topicModel = courseController.getTopic("105");
		 
        //assertThat(topicModel.get().getName()).isEqualTo("Javaa");
        //assertThat(topicModel.equals(t));
	}
}


