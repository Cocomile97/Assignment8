package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Degree;
import java.util.HashSet;
import java.util.Set;


public interface DegreeRepository extends  IRepository<Degree, String> {
    Set<Degree> getAll();

}
