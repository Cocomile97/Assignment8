package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DeptRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.DeptRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Dept;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.DeptService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DeptServiceImpl implements DeptService {

    private static DeptServiceImpl service = null;
    private DeptRepository repository;

    private DeptServiceImpl() {
        this.repository = DeptRepositoryImpl.getRepository();
    }

    public static DeptServiceImpl getService(){
        if (service == null) service = new DeptServiceImpl();
        return service;
    }

    @Override
    public Dept create(Dept dept) {
        return this.repository.create(dept);
    }

    @Override
    public Dept update(Dept dept) {
        return this.repository.update(dept);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Dept read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Dept> getAll() {
        return this.repository.getAll();
    }
}