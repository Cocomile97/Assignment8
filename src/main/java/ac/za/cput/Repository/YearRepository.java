package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Year;

import java.util.HashSet;
import java.util.Set;

public interface YearRepository extends  IRepository<Year, String> {
    Set<Year> getAll();
}
