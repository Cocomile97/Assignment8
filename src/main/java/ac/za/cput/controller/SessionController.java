package ac.za.cput.controller;
import ac.za.cput.domain.Session;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.SessionService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    @Qualifier("ServiceImpl")
    private SessionService service;

    @PostMapping("/create")
    @ResponseBody
    public Session create(Session session) {
        return service.create(session);
    }

    @PostMapping("/update")
    @ResponseBody
    public Session update(Session session) {
        return service.create(session);
    }


    @GetMapping("/delete/{type}")
    @ResponseBody
    public void delete(@PathVariable String sessionType) {
        service.delete(sessionType);

    }

    @GetMapping("/read/{type}")
    @ResponseBody
    public Session read(@PathVariable String sessionType) {
        return service.read(sessionType);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Session> getAll() {
        return service.getAll();
    }

}