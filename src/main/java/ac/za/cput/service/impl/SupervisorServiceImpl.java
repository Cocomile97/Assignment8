package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SupervisorRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SupervisorRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Supervisor;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    private static SupervisorServiceImpl service = null;
    private SupervisorRepository repository;

    private SupervisorServiceImpl() {
        this.repository = SupervisorRepositoryImpl.getRepository();
    }

    public static SupervisorServiceImpl getService(){
        if (service == null) service = new SupervisorServiceImpl();
        return service;
    }

    @Override
    public Supervisor create(Supervisor supervisor) {
        return this.repository.create(supervisor);
    }

    @Override
    public Supervisor update(Supervisor supervisor) {
        return this.repository.update(supervisor);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Supervisor read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Supervisor> getAll() {
        return this.repository.getAll();
    }
}