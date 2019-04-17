package ac.za.cput.factory;

import ac.za.cput.domain.Location;
import junit.framework.Assert;
import org.junit.Test;

public class LocationFactoryTest {

    @Test
    public void getLocation() {

        String name = "Exercises";
        String id="1A";
        Location a = LocationFactory.getLocation(name,id);
        System.out.println(a);
        Assert.assertEquals( "1A",a.getLocationId());
    }
}
