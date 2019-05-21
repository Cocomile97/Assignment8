package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SubjectRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SubjectRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Subject;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SubjectServiceImpl implements SubjectService {

    private static SubjectServiceImpl service = null;
    private SubjectRepository repository;

    private SubjectServiceImpl() {
        this.repository = SubjectRepositoryImpl.getRepository();
    }

    public static SubjectServiceImpl getService(){
        if (service == null) service = new SubjectServiceImpl();
        return service;
    }

    @Override
    public Subject create(Subject subject) {
        return this.repository.create(subject);
    }

    @Override
    public Subject update(Subject subject) {
        return this.repository.update(subject);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Subject read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Subject> getAll() {
        return this.repository.getAll();
    }
}