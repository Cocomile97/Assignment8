package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DegreeRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Degree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DegreeRepositoryImpl implements DegreeRepository {

    private static DegreeRepositoryImpl repository = null;
    private Set<Degree> degrees;

    private DegreeRepositoryImpl(){
        this.degrees = new HashSet();
    }

    private Degree findDegree(String degreeName) {
        return this.degrees.stream()
                .filter(degree -> degree.getDegreeName().trim().equals(degreeName))
                .findAny()
                .orElse(null);
    }

    public static DegreeRepositoryImpl getRepository(){
        if (repository == null) repository = new DegreeRepositoryImpl();
        return repository;
    }


    public Degree create(Degree degree){
        this.degrees.add(degree);
        return degree;
    }

    public Degree read(final String degreeName){
        Degree degree = findDegree(degreeName);
        return degree;
    }

    public void delete(String degreeName) {
        Degree degree = findDegree(degreeName);
        if (degree != null) this.degrees.remove(degree);
    }

    public Degree update(Degree degree){
        Degree toDelete = findDegree(degree.getDegreeName());
        if(toDelete != null) {
            this.degrees.remove(toDelete);
            return create(degree);
        }
        return null;
    }


    public Set<Degree> getAll(){
        return this.degrees;
    }
}
