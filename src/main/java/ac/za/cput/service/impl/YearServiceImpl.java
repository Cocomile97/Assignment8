package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.YearRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.YearRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Year;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.YearService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class YearServiceImpl implements YearService {

    private static YearServiceImpl service = null;
    private YearRepository repository;

    private YearServiceImpl() {
        this.repository = YearRepositoryImpl.getRepository();
    }

    public static YearServiceImpl getService(){
        if (service == null) service = new YearServiceImpl();
        return service;
    }

    @Override
    public Year create(Year year) {
        return this.repository.create(year);
    }

    @Override
    public Year update(Year year) {
        return this.repository.update(year);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Year read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Year> getAll() {
        return this.repository.getAll();
    }
}