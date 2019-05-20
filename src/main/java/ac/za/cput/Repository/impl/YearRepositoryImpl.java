package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.YearRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Topic;
import ac.za.cput.domain.Year;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class YearRepositoryImpl implements YearRepository {

    private static YearRepositoryImpl repository = null;
    private Set<Year> years;

    private YearRepositoryImpl(){
        this.years = new HashSet();
    }

    private Year findYear(String yearNum) {
        return this.years.stream()
                .filter(year -> year.getyearNum().trim().equals(yearNum))
                .findAny()
                .orElse(null);
    }

    public static YearRepositoryImpl getRepository(){
        if (repository == null) repository = new YearRepositoryImpl();
        return repository;
    }


    public Year create(Year year){
        this.years.add(year);
        return year;
    }
    public Year read(final String yearNum){
        Year year = findYear(yearNum);
        return year;
    }
    public void delete(String yearNum) {
        Year year = findYear(yearNum);
        if (year != null) this.years.remove(year);
    }

    public Year update(Year year){
        Year toDelete = findYear(year.getyearNum());
        if(toDelete != null) {
            this.years.remove(toDelete);
            return create(year);
        }
        return null;
    }


    public Set<Year> getAll(){
        return this.years;
    }
}
