package ac.za.cput.Repository;

import ac.za.cput.domain.Assignment;

import java.util.HashSet;
import java.util.Set;

public interface AssignmentRepository extends IRepository<Assignment, String> {
    Set<Assignment> getAll();

}
