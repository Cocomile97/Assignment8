package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LocationRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {

    private static LocationServiceImpl service = null;
    private LocationRepository repository;

    private LocationServiceImpl() {
        this.repository = LocationRepositoryImpl.getRepository();
    }

    public static LocationServiceImpl getService(){
        if (service == null) service = new LocationServiceImpl();
        return service;
    }

    @Override
    public Location create(Location location) {
        return this.repository.create(location);
    }

    @Override
    public Location update(Location location) {
        return this.repository.update(location);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Location read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Location> getAll() {
        return this.repository.getAll();
    }
}