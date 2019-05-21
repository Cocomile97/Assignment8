package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.OfficeRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.OfficeRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Office;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.OfficeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OfficeServiceImpl implements OfficeService {

    private static OfficeServiceImpl service = null;
    private OfficeRepository repository;

    private OfficeServiceImpl() {
        this.repository = OfficeRepositoryImpl.getRepository();
    }

    public static OfficeServiceImpl getService(){
        if (service == null) service = new OfficeServiceImpl();
        return service;
    }

    @Override
    public Office create(Office office) {
        return this.repository.create(office);
    }

    @Override
    public Office update(Office office) {
        return this.repository.update(office);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Office read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Office> getAll() {
        return this.repository.getAll();
    }
}