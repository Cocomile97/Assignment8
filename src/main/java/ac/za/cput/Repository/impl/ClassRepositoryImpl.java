package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.ClassRepository;
import ac.za.cput.domain.Class;
import ac.za.cput.domain.Class;

import java.util.HashSet;
import java.util.Set;

public class ClassRepositoryImpl implements ClassRepository {

    private static ClassRepository repository = null;
    private Set<Class> classes;

    private ClassRepositoryImpl(){
        this.classes = new HashSet<Class>();
    }

    public static ClassRepository getRepository(){
        if (repository == null) repository = new ClassRepositoryImpl();
        return repository;
    }

    public Class create(Class clasi) {
        //insert into the set of departments
        return clasi;
    }

    public Class read(String classId){
        // find the department with the id and return it

        return null;
    }

    public Class update(Class clasi){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String classId) {
        // find the department with id and delete it
    }

    public Set<Class> getAll(){



        return this.classes;
    }
}