package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.TopicRepository;
import ac.za.cput.domain.Topic;

import java.util.HashSet;
import java.util.Set;

public class TopicRepositoryImpl implements TopicRepository {

    private static TopicRepository repository = null;
    private Set<Topic> topics;

    private TopicRepositoryImpl(){
        this.topics = new HashSet<Topic>();
    }

    public static TopicRepository getRepository(){
        if (repository == null) repository = new TopicRepositoryImpl();
        return repository;
    }

    public Topic create(Topic topic) {
        //insert into the set of departments
        return topic;
    }

    public Topic read(String topicNum){
        // find the department with the id and return it

        return null;
    }

    public Topic update(Topic topic){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String topicNum) {
        // find the department with id and delete it
    }

    public Set<Topic> getAll(){



        return this.topics;
    }
}