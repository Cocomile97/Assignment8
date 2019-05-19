package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Supervisor;

import java.util.HashSet;
import java.util.Set;

public interface SupervisorRepository extends  IRepository<Supervisor, String> {
    Set<Supervisor> getAll();
}
