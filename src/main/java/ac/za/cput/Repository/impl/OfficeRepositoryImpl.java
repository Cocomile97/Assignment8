package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.OfficeRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Office;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OfficeRepositoryImpl implements OfficeRepository {

    private static OfficeRepositoryImpl repository = null;
    private Set<Office> offices;

    private OfficeRepositoryImpl(){
        this.offices = new HashSet();
    }

    private Office findOffice(String officeId) {
        return this.offices.stream()
                .filter(office -> office.getOfficeId().trim().equals(officeId))
                .findAny()
                .orElse(null);
    }

    public static OfficeRepositoryImpl getRepository(){
        if (repository == null) repository = new OfficeRepositoryImpl();
        return repository;
    }


    public Office create(Office office){
        this.offices.add(office);
        return office;
    }

    public Office read(final String officeId){
        Office office = findOffice(officeId);
        return office;
    }

    public void delete(String officeId) {
        Office office = findOffice(officeId);
        if (office != null) this.offices.remove(office);
    }

    public Office update(Office office){
        Office toDelete = findOffice(office.getOfficeId());
        if(toDelete != null) {
            this.offices.remove(toDelete);
            return create(office);
        }
        return null;
    }


    public Set<Office> getAll(){
        return this.offices;
    }
}
