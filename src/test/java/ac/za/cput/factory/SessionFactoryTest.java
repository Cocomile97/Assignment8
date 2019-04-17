package ac.za.cput.factory;

import ac.za.cput.domain.Session;
import org.junit.Assert;
import org.junit.Test;

public class SessionFactoryTest {

    @Test
    public void getSession() {

        String duration= "2 hours";
        String type = "question and answer";
        Session c = SessionFactory.getSession(duration,type);
        System.out.println(c);
        Assert.assertNotNull(c.getsessionDuration());
        Assert.assertNotNull(c.getsessionType());
    }
}
