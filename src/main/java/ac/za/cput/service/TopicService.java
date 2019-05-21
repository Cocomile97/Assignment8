package ac.za.cput.service;

import ac.za.cput.domain.Topic;

import java.util.Set;

public interface TopicService extends IService<Topic, String> {
    Set<Topic> getAll();
}
