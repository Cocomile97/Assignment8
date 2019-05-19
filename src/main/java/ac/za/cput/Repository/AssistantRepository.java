package ac.za.cput.Repository;

import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Assistant;

import java.util.HashSet;
import java.util.Set;

public interface AssistantRepository extends  IRepository<Assistant, String> {
    Set<Assistant> getAll();
}
