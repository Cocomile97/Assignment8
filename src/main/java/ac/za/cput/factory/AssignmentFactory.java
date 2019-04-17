package ac.za.cput.factory;

import ac.za.cput.domain.Assignment;

public class AssignmentFactory {


    public static Assignment getAssignment(String assignmentName,String id) {
        return new Assignment.Builder().assignmentId(id)
                .assignmentName(assignmentName)
                .build();
    }
}

