package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Lecturer;

import java.util.HashSet;
import java.util.Set;

public interface LecturerRepository extends  IRepository<Lecturer, String> {
    Set<Lecturer> getAll();
}
