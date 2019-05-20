package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.SupervisorRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Supervisor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SupervisorRepositoryImpl implements SupervisorRepository {

    private static SupervisorRepositoryImpl repository = null;
    private Set<Supervisor> supervisors;

    private SupervisorRepositoryImpl(){
        this.supervisors = new HashSet();
    }

    private Supervisor findSupervisor(String supervisorName) {
        return this.supervisors.stream()
                .filter(supervisor -> supervisor.getSupervisorName().trim().equals(supervisorName))
                .findAny()
                .orElse(null);
    }

    public static SupervisorRepositoryImpl getRepository(){
        if (repository == null) repository = new SupervisorRepositoryImpl();
        return repository;
    }


    public Supervisor create(Supervisor supervisor){
        this.supervisors.add(supervisor);
        return supervisor;
    }

    public Supervisor read(final String supervisorName){
        Supervisor supervisor = findSupervisor(supervisorName);
        return supervisor;
    }

    public void delete(String supervisorName) {
        Supervisor supervisor = findSupervisor(supervisorName);
        if (supervisor != null) this.supervisors.remove(supervisor);
    }

    public Supervisor update(Supervisor supervisor){
        Supervisor toDelete = findSupervisor(supervisor.getSupervisorName());
        if(toDelete != null) {
            this.supervisors.remove(toDelete);
            return create(supervisor);
        }
        return null;
    }


    public Set<Supervisor> getAll(){
        return this.supervisors;
    }
}
