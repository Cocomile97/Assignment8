package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.StudentRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.StudentRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Student;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private static StudentServiceImpl service = null;
    private StudentRepository repository;

    private StudentServiceImpl() {
        this.repository = StudentRepositoryImpl.getRepository();
    }

    public static StudentServiceImpl getService(){
        if (service == null) service = new StudentServiceImpl();
        return service;
    }

    @Override
    public Student create(Student student) {
        return this.repository.create(student);
    }

    @Override
    public Student update(Student student) {
        return this.repository.update(student);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Student read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Student> getAll() {
        return this.repository.getAll();
    }
}