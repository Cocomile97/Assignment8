package ac.za.cput.controller;
import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.CalendarService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/calendar")
public class CalendarController {
    @Autowired
    @Qualifier("ServiceImpl")
    private CalendarService service;

    @PostMapping("/create")
    @ResponseBody
    public Calendar create(Calendar calendar) {
        return service.create(calendar);
    }

    @PostMapping("/update")
    @ResponseBody
    public Calendar update(Calendar calendar) {
        return service.create(calendar);
    }


    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String calendarName) {
        service.delete(calendarName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Calendar read(@PathVariable String calendarName) {
        return service.read(calendarName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Calendar> getAll() {
        return service.getAll();
    }

}