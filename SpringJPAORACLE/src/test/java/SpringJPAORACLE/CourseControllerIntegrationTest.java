package SpringJPAORACLE;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.net.URI;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import SpringJPAORACLE.Controller.CourseController;
import SpringJPAORACLE.Model.TopicModel;
import SpringJPAORACLE.Repo.TopicRepository;
import SpringJPAORACLE.Service.TopicService;

//@AutoConfigureMockMvc
//@RestClientTest(classes = {CourseController.class, TopicService.class}, webEnvironment =WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CourseControllerIntegrationTest
{
	@LocalServerPort
	private int port;
	
	@Autowired
	private TopicService tserv;
 
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Mock
	private TopicRepository topicRepository;
 
    @Test
    public void testAllTopics() throws Exception
    {
    	TopicModel t= new TopicModel();
		t.setId("100");
		t.setName("Java");
		t.setDescription("Core Java");
		
		when( topicRepository.findByName()) .thenReturn(t); 
		
		final String baseUrl = "http://localhost:" + port + "/test";
		URI uri =  new URI(baseUrl);
		
		HttpEntity<TopicModel> httpEntity = new HttpEntity<>(t);
		TopicModel responseEntity = this.restTemplate.getForObject(uri, TopicModel.class);
		System.out.println(responseEntity);
		
		Assert.assertEquals(t.getName(), responseEntity.getName());
    }
}