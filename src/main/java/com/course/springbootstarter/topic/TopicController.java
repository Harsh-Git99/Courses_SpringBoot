package com.course.springbootstarter.topic;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;

	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
				
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopic(@PathVariable int id) {
		return topicService.getTopic(id);
	}
	
	
	@PostMapping("/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	//add multiples
	@PostMapping("/topics/multi")
	public void addTopics(@RequestBody List<Topic> list) {
		topicService.addTopics(list);
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic,@PathVariable int id ) {
		topicService.updateTopic(id, topic);
		
	}
	
	@DeleteMapping("/topics/{id}")
	public String  deleteTopic(@PathVariable int id) {
		 topicService.deleteTopic(id);
		 return "Deleted";	
	}
	
	@DeleteMapping("/topics/deleteAll")
	public String  deleteTopic() {
		 topicService.deleteAllTopic();
		 return "Deleted all the product";	
	}
}
