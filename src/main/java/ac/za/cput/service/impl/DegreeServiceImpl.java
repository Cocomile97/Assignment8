package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DegreeRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.DegreeRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Degree;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.DegreeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DegreeServiceImpl implements DegreeService {

    private static DegreeServiceImpl service = null;
    private DegreeRepository repository;

    private DegreeServiceImpl() {
        this.repository = DegreeRepositoryImpl.getRepository();
    }

    public static DegreeServiceImpl getService(){
        if (service == null) service = new DegreeServiceImpl();
        return service;
    }

    @Override
    public Degree create(Degree degree) {
        return this.repository.create(degree);
    }

    @Override
    public Degree update(Degree degree) {
        return this.repository.update(degree);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Degree read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Degree> getAll() {
        return this.repository.getAll();
    }
}