package ac.za.cput.service.impl;

import ac.za.cput.Repository.AssistantRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.impl.AssistantRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;
import ac.za.cput.service.AssistantService;
import ac.za.cput.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AssistantServiceImpl implements AssistantService {

    private static AssistantServiceImpl service = null;
    private AssistantRepository repository;

    private AssistantServiceImpl() {
        this.repository = AssistantRepositoryImpl.getRepository();
    }

    public static AssistantServiceImpl getService(){
        if (service == null) service = new AssistantServiceImpl();
        return service;
    }

    @Override
    public Assistant create(Assistant assistant) {
        return this.repository.create(assistant);
    }

    @Override
    public Assistant update(Assistant assistant) {
        return this.repository.update(assistant);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Assistant read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Assistant> getAll() {
        return this.repository.getAll();
    }
}