package ac.za.cput.factory;

import ac.za.cput.domain.Supervisor;
import org.junit.Assert;
import org.junit.Test;

public class SupervisorFactoryTest {

    @Test
    public void getDegree() {

        String name = "Masters";
        String level = "Post graduate";
        Supervisor c = SupervisorFactory.getSupervisor(name,level);
        System.out.println(c);
        Assert.assertNotNull(c.getsupervisorLevel());
        Assert.assertNotNull(c.getSupervisorName());
    }
}
