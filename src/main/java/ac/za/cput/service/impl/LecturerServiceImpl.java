package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LecturerRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LecturerRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecturer;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LecturerServiceImpl implements LecturerService {

    private static LecturerServiceImpl service = null;
    private LecturerRepository repository;

    private LecturerServiceImpl() {
        this.repository = LecturerRepositoryImpl.getRepository();
    }

    public static LecturerServiceImpl getService(){
        if (service == null) service = new LecturerServiceImpl();
        return service;
    }

    @Override
    public Lecturer create(Lecturer lecturer) {
        return this.repository.create(lecturer);
    }

    @Override
    public Lecturer update(Lecturer lecturer) {
        return this.repository.update(lecturer);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Lecturer read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Lecturer> getAll() {
        return this.repository.getAll();
    }
}