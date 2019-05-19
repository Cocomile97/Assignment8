package ac.za.cput.Repository;

import ac.za.cput.domain.Lecturer;
import ac.za.cput.domain.Location;

import java.util.HashSet;
import java.util.Set;

public interface LocationRepository extends  IRepository<Location, String> {
    Set<Location> getAll();
}
