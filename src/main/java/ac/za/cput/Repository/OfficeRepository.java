package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Office;

import java.util.HashSet;
import java.util.Set;

public interface OfficeRepository extends  IRepository<Office, String> {
    Set<Office> getAll();
}
