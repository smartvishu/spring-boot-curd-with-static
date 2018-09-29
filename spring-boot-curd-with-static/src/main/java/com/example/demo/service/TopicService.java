package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Topic;

@Service
public class TopicService {

	
	// this is the mutable array so we add change in the same
	private List<Topic> topics = new ArrayList <>(Arrays.asList(new Topic("1", "Vishnu", "Having Fun"),
			new Topic("2", "Prahlad", "Doing good"), new Topic("3", "Vinay", "Looking For Onsite")));
/* this is the immutable array so we can't change in the same
	private List<Topic> topics =Arrays.asList(new Topic("1", "Vishnu", "Having Fun"),
			new Topic("2", "Prahlad", "Doing good"), new Topic("3", "Vinay", "Looking For Onsite"));*/
	
	
	public List<Topic> getAllTopics() {

		return topics;

	}

	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();

	}

	public void addTopic(Topic topic) {

	topics.add(topic);
	
	}

	public void updateTopic(String id, Topic topic) {
		for(int i =0; i<topics.size();i++){
			Topic t=topics.get(i);
			if(t.getId().equals(id)){
				topics.set(i, topic);
				return;
			}
		}

	}

	public void deleteTopic(String id, Topic topic) {
		
		topics.removeIf(t->t.getId().equals(id));
	}

}
