package ac.za.cput.service.impl;

import ac.za.cput.Repository.CalendarRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.impl.CalendarRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Course;
import ac.za.cput.service.CalendarService;
import ac.za.cput.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CalendarServiceImpl implements CalendarService {

    private static CalendarServiceImpl service = null;
    private CalendarRepository repository;

    private CalendarServiceImpl() {
        this.repository = CalendarRepositoryImpl.getRepository();
    }

    public static CalendarServiceImpl getService(){
        if (service == null) service = new CalendarServiceImpl();
        return service;
    }

    @Override
    public Calendar create(Calendar calendar) {
        return this.repository.create(calendar);
    }

    @Override
    public Calendar update(Calendar calendar) {
        return this.repository.update(calendar);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Calendar read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Calendar> getAll() {
        return this.repository.getAll();
    }
}