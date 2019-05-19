package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Dept;

import java.util.HashSet;
import java.util.Set;

public interface DeptRepository extends  IRepository<Dept, String> {
    Set<Dept> getAll();
}
