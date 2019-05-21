package ac.za.cput.service;

import ac.za.cput.Repository.impl.CalendarRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
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
public class CalendarServiceImplTest {

    private CalendarRepositoryImpl repository;
    private Calendar calendar;

    private Calendar getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = CalendarRepositoryImpl.getRepository();
        this.calendar = CalendarFactory.getCalendar("","");
    }

    @Test
    public void a_create() {
        Calendar created = this.repository.create(this.calendar);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.calendar);
    }

    @Test
    public void c_update() {
        String newCalendarName = "Calendar3";
        Calendar updated = new Calendar.Builder().copy(getSaved()).calendarName(newCalendarName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newCalendarName, updated.getCalendarName());
    }

    @Test
    public void e_delete() {
        Calendar saved = getSaved();
        this.repository.delete(saved.getCalendarName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Calendar saved = getSaved();
        Calendar read = this.repository.read(saved.getCalendarName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Calendar> calendars = this.repository.getAll();
        System.out.println("In getall, all = " + calendars);
    }
}