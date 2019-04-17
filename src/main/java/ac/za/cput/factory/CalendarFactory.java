package ac.za.cput.factory;

import ac.za.cput.domain.Calendar;
import ac.za.cput.util.Misc;

public class CalendarFactory {


    public static Calendar getCalendar(String calendarType, String calendarName) {

        return new Calendar.Builder().calendarType(calendarType)
                .calendarName(calendarName)
                .build();
    }
}