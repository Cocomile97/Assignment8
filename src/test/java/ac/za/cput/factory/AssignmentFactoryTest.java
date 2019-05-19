package ac.za.cput.factory;

import ac.za.cput.domain.Account;
import ac.za.cput.domain.Assignment;
import org.junit.Assert;
import org.junit.Test;

public class AssignmentFactoryTest {

    @Test
    public void getAssignment() {

        String id = "";
        String name = "Premium";
        Assignment c = AssignmentFactory.getAssignment(name,id);
        System.out.println(c);
        Assert.assertNotNull(c.getAssignmentId());
        Assert.assertNotNull(c.getAssignmentName());
    }
}
