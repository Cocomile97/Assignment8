package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.SessionRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SessionRepositoryImpl implements SessionRepository {

    private static SessionRepositoryImpl repository = null;
    private Set<Session> sessions;

    private SessionRepositoryImpl(){
        this.sessions = new HashSet();
    }

    private Session findSession(String sessionType) {
        return this.sessions.stream()
                .filter(session -> session.getsessionType().trim().equals(sessionType))
                .findAny()
                .orElse(null);
    }

    public static SessionRepositoryImpl getRepository(){
        if (repository == null) repository = new SessionRepositoryImpl();
        return repository;
    }


    public Session create(Session session){
        this.sessions.add(session);
        return session;
    }

    public Session read(final String sessionType){
        Session session = findSession(sessionType);
        return session;
    }

    public void delete(String sessionType) {
        Session session = findSession(sessionType);
        if (session != null) this.sessions.remove(session);
    }

    public Session update(Session session){
        Session toDelete = findSession(session.getsessionType());
        if(toDelete != null) {
            this.sessions.remove(toDelete);
            return create(session);
        }
        return null;
    }


    public Set<Session> getAll(){
        return this.sessions;
    }
}
