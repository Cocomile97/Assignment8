package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Project;

import java.util.HashSet;
import java.util.Set;

public interface ProjectRepository extends  IRepository<Project, String> {
    Set<Project> getAll();
}
