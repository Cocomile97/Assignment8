package ac.za.cput.service;

import ac.za.cput.domain.Location;

import java.util.Set;

public interface LocationService extends IService<Location, String> {
    Set<Location> getAll();
}