package ac.za.cput.Repository;

import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Calendar;

import java.util.HashSet;
import java.util.Set;

public interface CalendarRepository extends  IRepository<Calendar, String> {
    Set<Calendar> getAll();
}
