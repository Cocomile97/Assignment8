package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.AssignmentRepository;
import ac.za.cput.domain.Assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AssignmentRepositoryImpl implements AssignmentRepository {

    private static AssignmentRepositoryImpl repository = null;
    private Set<Assignment> assignments;

    private AssignmentRepositoryImpl(){
        this.assignments = new HashSet();
    }

    private Assignment findAssignment(String assignmentId) {
        return this.assignments.stream()
                .filter(assignment -> assignment.getAssignmentId().trim().equals(assignmentId))
                .findAny()
                .orElse(null);
    }

    public static AssignmentRepositoryImpl getRepository(){
        if (repository == null) repository = new AssignmentRepositoryImpl();
        return repository;
    }


    public Assignment create(Assignment assignment){
        this.assignments.add(assignment);
        return assignment;
    }

    public Assignment read(final String assignmentId){
        Assignment assignment = findAssignment(assignmentId);
        return assignment;
    }

    public void delete(String assignmentId) {
        Assignment assignment = findAssignment(assignmentId);
        if (assignment != null) this.assignments.remove(assignment);
    }

    public Assignment update(Assignment assignment){
        Assignment toDelete = findAssignment(assignment.getAssignmentId());
        if(toDelete != null) {
            this.assignments.remove(toDelete);
            return create(assignment);
        }
        return null;
    }


    public Set<Assignment> getAll(){
        return this.assignments;
    }
}
