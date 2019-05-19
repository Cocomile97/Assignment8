package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.SessionRepository;
import ac.za.cput.domain.Session;

import java.util.HashSet;
import java.util.Set;

public class SessionRepositoryImpl implements SessionRepository {

    private static SessionRepository repository = null;
    private Set<Session> sessions;

    private SessionRepositoryImpl(){
        this.sessions = new HashSet<Session>();
    }

    public static SessionRepository getRepository(){
        if (repository == null) repository = new SessionRepositoryImpl();
        return repository;
    }

    public Session create(Session session) {
        //insert into the set of departments
        return session;
    }

    public Session read(String sessionType){
        // find the department with the id and return it

        return null;
    }

    public Session update(Session session){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String sessionType) {
        // find the department with id and delete it
    }

    public Set<Session> getAll(){



        return this.sessions;
    }
}