package ac.za.cput.factory;

import ac.za.cput.domain.Degree;
import org.junit.Assert;
import org.junit.Test;

public class DegreeFactoryTest {

    @Test
    public void getDegree() {

        String name = "Masters";
        String type = "Post graduate";
        Degree c = DegreeFactory.getDegree(name,type);
        System.out.println(c);
        Assert.assertNotNull(c.getDegreeLevel());
        Assert.assertNotNull(c.getDegreeName());
    }
}
