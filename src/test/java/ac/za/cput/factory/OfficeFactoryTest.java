package ac.za.cput.factory;

import ac.za.cput.domain.Office;
import org.junit.Assert;
import org.junit.Test;

public class OfficeFactoryTest {

    @Test
    public void getOffice() {

        String name = "Information Technology";
        String id="A";
        Office a = OfficeFactory.getOffice(name,id);
        System.out.println(a);
        Assert.assertEquals( "A",a.getOfficeId());
    }
}
