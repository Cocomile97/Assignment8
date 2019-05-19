package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Class;

import java.util.HashSet;
import java.util.Set;

public interface ClassRepository extends  IRepository<Class, String> {
    Set<Class> getAll();
}
