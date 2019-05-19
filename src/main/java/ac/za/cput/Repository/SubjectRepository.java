package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Subject;

import java.util.HashSet;
import java.util.Set;

public interface SubjectRepository extends  IRepository<Subject, String> {
    Set<Subject> getAll();
}
