package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CalendarRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Course;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CalendarRepositoryImpl implements CalendarRepository {

    private static CalendarRepositoryImpl repository = null;
    private Set<Calendar> calendars;

    private CalendarRepositoryImpl(){
        this.calendars = new HashSet();
    }

    private Calendar findCalendar(String calendarName) {
        return this.calendars.stream()
                .filter(calendar -> calendar.getCalendarName().trim().equals(calendarName))
                .findAny()
                .orElse(null);
    }

    public static CalendarRepositoryImpl getRepository(){
        if (repository == null) repository = new CalendarRepositoryImpl();
        return repository;
    }


    public Calendar create(Calendar calendar){
        this.calendars.add(calendar);
        return calendar;
    }

    public Calendar read(final String calendarName){
        Calendar calendar = findCalendar(calendarName);
        return calendar;
    }

    public void delete(String calendarName) {
        Calendar calendar = findCalendar(calendarName);
        if (calendar != null) this.calendars.remove(calendar);
    }

    public Calendar update(Calendar calendar){
        Calendar toDelete = findCalendar(calendar.getCalendarName());
        if(toDelete != null) {
            this.calendars.remove(toDelete);
            return create(calendar);
        }
        return null;
    }


    public Set<Calendar> getAll(){
        return this.calendars;
    }
}
