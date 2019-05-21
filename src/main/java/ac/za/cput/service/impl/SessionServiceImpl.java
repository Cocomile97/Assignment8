package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SessionRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SessionRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Session;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.SessionService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SessionServiceImpl implements SessionService {

    private static SessionServiceImpl service = null;
    private SessionRepository repository;

    private SessionServiceImpl() {
        this.repository = SessionRepositoryImpl.getRepository();
    }

    public static SessionServiceImpl getService(){
        if (service == null) service = new SessionServiceImpl();
        return service;
    }

    @Override
    public Session create(Session session) {
        return this.repository.create(session);
    }

    @Override
    public Session update(Session session) {
        return this.repository.update(session);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Session read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Session> getAll() {
        return this.repository.getAll();
    }
}