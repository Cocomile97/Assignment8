package ac.za.cput.repository;

import ac.za.cput.Repository.CalendarRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.impl.CalendarRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Course;
import ac.za.cput.factory.CalendarFactory;
import ac.za.cput.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalendarRepositoryImplTest {

    private CalendarRepository repository;
    private Calendar calendar;

    private Calendar getSavedCalendar() {
        Set<Calendar> savedCalendars = this.repository.getAll();
        return savedCalendars.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CalendarRepositoryImpl.getRepository();
        this.calendar =  CalendarFactory.getCalendar("Test Course", "");
    }

    @Test
    public void a_create() {
        Calendar created = this.repository.create(this.calendar);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.calendar);
    }

    @Test
    public void b_read() {
        Calendar savedCalendar = getSavedCalendar();
        System.out.println("In read, courseId = "+ savedCalendar.getCalendarName());
        Calendar read = this.repository.read(calendar.getCalendarName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedCalendar, read);
    }

    @Test
    public void e_delete() {
        Calendar savedCalendar = getSavedCalendar();
        this.repository.delete(savedCalendar.getCalendarName());
        d_getAll();
    }
    @Test
    public void c_update() {
            String newname = "New Test Course Name";
            Calendar calendar = new Calendar.Builder().copy(getSavedCalendar()).calendarName(newname).build();
            System.out.println("In update, about_to_updated = " + calendar);
            Calendar updated = this.repository.update(calendar);
            System.out.println("In update, updated = " + updated);
            Assert.assertSame(newname, updated.getCalendarName());
            d_getAll();
        }

    @Test
    public void d_getAll() {
        Set<Calendar> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
