package ac.za.cput.factory;

import ac.za.cput.domain.Calendar;
import org.junit.Assert;
import org.junit.Test;

public class CalendarFactoryTest {

    @Test
    public void getCalendar() {

        String name = "";
        String type = "";
        Calendar a = CalendarFactory.getCalendar(name,type);
        System.out.println(a);
        Assert.assertNotNull(a.getCalendarName());
    }
}
