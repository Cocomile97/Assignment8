package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.SubjectRepository;
import ac.za.cput.domain.Subject;

import java.util.HashSet;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository {

    private static SubjectRepository repository = null;
    private Set<Subject> subjects;

    private SubjectRepositoryImpl(){
        this.subjects = new HashSet<Subject>();
    }

    public static SubjectRepository getRepository(){
        if (repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }

    public Subject create(Subject subject) {
        //insert into the set of departments
        return subject;
    }

    public Subject read(String subjectName){
        // find the department with the id and return it

        return null;
    }

    public Subject update(Subject subject){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String subjectName) {
        // find the department with id and delete it
    }

    public Set<Subject> getAll(){



        return this.subjects;
    }
}