package SpringJPAORACLE.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import SpringJPAORACLE.Model.TopicModel;
import SpringJPAORACLE.Service.TopicService;
import SpringJPAORACLE.Utility.JsonUtility;

@RestController
public class CourseController {

	@Autowired
	private TopicService tserv;

	@RequestMapping("/")
	public void getProject() {
		Integer a=null;
		System.out.println("In SpringJPAORACLE.....");
		
	}
	
	@RequestMapping("/test")
	public @ResponseBody TopicModel getAll() {
		return tserv.getAll();
		
	}

	@RequestMapping("/alltopics")
	public @ResponseBody List<TopicModel> getAllTopics() {
		return tserv.getAllTopics();
	}
	
	@RequestMapping("/topics/{id}")
	public Optional<TopicModel> getTopic(@PathVariable String id) {
		return tserv.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/topic") 
	public void addTopic(@RequestBody TopicModel topic) 
	{ 
		tserv.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/alltopics")
	public void addTopic(@RequestBody List<TopicModel> topic) {
		
		for(TopicModel tm: topic) {
			if("something".equalsIgnoreCase(tm.getName())) {
				tm.setName("Core Java");
			}	
		}
		tserv.addAllTopic(topic);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/jsonTesting")
	public void jsonTesting(@RequestBody List<TopicModel> topic) 
	{
		List<String> listString= new ArrayList<String>();
		for(TopicModel tm: topic) 
		{
		  String st= JsonUtility.converttoJson(tm);
		  listString.add(st);
		  
		  JsonObject data= new Gson().fromJson(st, JsonObject.class);
		  System.out.println("JsonObject data"+ data);
		  
		  JsonElement element = data.getAsJsonObject();
		  System.out.println("JsonElement element "+ element);
		  
		  TopicModel t= new TopicModel();
		  t.setName(element.getAsJsonObject().get("name").getAsString());
		  System.out.println("-->"+t.getName());
		 }
		System.out.println(listString);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "topics/{id}")
	public void updateTopic(@RequestBody TopicModel topic, @PathVariable String id) {
		tserv.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{id}")
	public void deleteTopic(@PathVariable String id) {
		tserv.deleteTopic(id);
	}
}
