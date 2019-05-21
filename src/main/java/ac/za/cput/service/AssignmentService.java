package ac.za.cput.service;

import ac.za.cput.domain.Assignment;

import java.util.Set;

public interface AssignmentService extends IService<Assignment, String> {
    Set<Assignment> getAll();
}
