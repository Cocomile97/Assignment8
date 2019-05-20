package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.TopicRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Topic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TopicRepositoryImpl implements TopicRepository {

    private static TopicRepositoryImpl repository = null;
    private Set<Topic> topics;

    private TopicRepositoryImpl(){
        this.topics = new HashSet();
    }

    private Topic findTopic(String topicName) {
        return this.topics.stream()
                .filter(topic -> topic.getTopicName().trim().equals(topicName))
                .findAny()
                .orElse(null);
    }

    public static TopicRepositoryImpl getRepository(){
        if (repository == null) repository = new TopicRepositoryImpl();
        return repository;
    }


    public Topic create(Topic topic){
        this.topics.add(topic);
        return topic;
    }

    public Topic read(final String topicName){
        Topic topic = findTopic(topicName);
        return topic;
    }

    public void delete(String topicName) {
        Topic topic = findTopic(topicName);
        if (topic != null) this.topics.remove(topic);
    }

    public Topic update(Topic topic){
        Topic toDelete = findTopic(topic.getTopicName());
        if(toDelete != null) {
            this.topics.remove(toDelete);
            return create(topic);
        }
        return null;
    }


    public Set<Topic> getAll(){
        return this.topics;
    }
}
