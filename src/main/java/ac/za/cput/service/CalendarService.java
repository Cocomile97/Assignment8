package ac.za.cput.service;

import ac.za.cput.domain.Calendar;

import java.util.Set;

public interface CalendarService extends IService<Calendar, String> {
    Set<Calendar> getAll();
}