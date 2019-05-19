package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.SupervisorRepository;
import ac.za.cput.domain.Supervisor;

import java.util.HashSet;
import java.util.Set;

public class SupervisorRepositoryImpl implements SupervisorRepository {

    private static SupervisorRepository repository = null;
    private Set<Supervisor> supervisors;

    private SupervisorRepositoryImpl(){
        this.supervisors = new HashSet<Supervisor>();
    }

    public static SupervisorRepository getRepository(){
        if (repository == null) repository = new SupervisorRepositoryImpl();
        return repository;
    }

    public Supervisor create(Supervisor supervisor) {
        //insert into the set of departments
    return supervisor;
    }

    public Supervisor read(String supervisorId){
        // find the department with the id and return it

        return null;
    }

    public Supervisor update(Supervisor supervisor){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String supervisorId) {
        // find the department with id and delete it
    }

    public Set<Supervisor> getAll(){



        return this.supervisors;
    }
}