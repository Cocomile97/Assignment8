package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LocationRepositoryImpl implements LocationRepository {

    private static LocationRepositoryImpl repository = null;
    private Set<Location> locations;

    private LocationRepositoryImpl(){
        this.locations = new HashSet();
    }

    private Location findLocation(String locationId) {
        return this.locations.stream()
                .filter(location -> location.getLocationId().trim().equals(locationId))
                .findAny()
                .orElse(null);
    }

    public static LocationRepositoryImpl getRepository(){
        if (repository == null) repository = new LocationRepositoryImpl();
        return repository;
    }


    public Location create(Location location){
        this.locations.add(location);
        return location;
    }

    public Location read(final String locationId){
        Location location = findLocation(locationId);
        return location;
    }

    public void delete(String locationId) {
        Location location = findLocation(locationId);
        if (location != null) this.locations.remove(location);
    }

    public Location update(Location location){
        Location toDelete = findLocation(location.getLocationId());
        if(toDelete != null) {
            this.locations.remove(toDelete);
            return create(location);
        }
        return null;
    }


    public Set<Location> getAll(){
        return this.locations;
    }
}
