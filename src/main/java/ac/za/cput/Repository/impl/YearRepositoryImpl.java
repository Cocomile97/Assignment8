package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.YearRepository;
import ac.za.cput.domain.Year;

import java.util.HashSet;
import java.util.Set;

public class YearRepositoryImpl implements YearRepository {

    private static YearRepository repository = null;
    private Set<Year> years;

    private YearRepositoryImpl(){
        this.years = new HashSet<Year>();
    }

    public static YearRepository getRepository(){
        if (repository == null) repository = new YearRepositoryImpl();
        return repository;
    }

    public Year create(Year year) {
        //insert into the set of departments
        return year;
    }

    public Year read(String yearNum){
        // find the department with the id and return it

        return null;
    }

    public Year update(Year year){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String yearNum) {
        // find the department with id and delete it
    }

    public Set<Year> getAll(){



        return this.years;
    }
}