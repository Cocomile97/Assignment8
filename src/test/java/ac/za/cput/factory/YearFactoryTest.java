package ac.za.cput.factory;

import ac.za.cput.domain.Year;
import org.junit.Assert;
import org.junit.Test;

public class YearFactoryTest {

    @Test
    public void getYear() {

        String num = "Year2";
        Year a = YearFactory.getYear(num);
        System.out.println(a);
        Assert.assertNotNull(a.getyearNum());
    }
}
