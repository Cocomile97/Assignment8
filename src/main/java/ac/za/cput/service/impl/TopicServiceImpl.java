package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.TopicRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.TopicRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Topic;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.TopicService;
import ac.za.cput.service.YearService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TopicServiceImpl implements TopicService {

    private static TopicServiceImpl service = null;
    private TopicRepository repository;

    private TopicServiceImpl() {
        this.repository = TopicRepositoryImpl.getRepository();
    }

    public static TopicServiceImpl getService(){
        if (service == null) service = new TopicServiceImpl();
        return service;
    }

    @Override
    public Topic create(Topic topic) {
        return this.repository.create(topic);
    }

    @Override
    public Topic update(Topic topic) {
        return this.repository.update(topic);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Topic read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Topic> getAll() {
        return this.repository.getAll();
    }
}