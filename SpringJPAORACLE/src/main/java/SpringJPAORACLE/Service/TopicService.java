package SpringJPAORACLE.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringJPAORACLE.Model.TopicModel;
import SpringJPAORACLE.Repo.TopicRepository;

import java.util.*;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	
	/*
	 * hey hey
	 */
	public List<TopicModel> getAllTopics() {
		
		List<TopicModel> topics = new ArrayList<>();
		//topicRepository.findAll().forEach(topics::add);
		topics = (List<TopicModel>) topicRepository.findAll();
		return topics;
	}
	
	public Optional<TopicModel> getTopic(String id){
		return topicRepository.findById(id);
	}
	
	public void addTopic(TopicModel topic) {
		topicRepository.save(topic);
	}
	
	public void addAllTopic(List<TopicModel> topics) {
		topicRepository.saveAll(topics);
	}
	
	public void updateTopic(String id, TopicModel topic) {
		topicRepository.save(topic);
	}
	
	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
	}

	public TopicModel getAll() {
		return topicRepository.findByName();
	}
}
