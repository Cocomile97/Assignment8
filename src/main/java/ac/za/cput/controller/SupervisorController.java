package ac.za.cput.controller;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Supervisor;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/supervisor")
public class SupervisorController {
    @Autowired
    @Qualifier("ServiceImpl")
    private SupervisorService service;

    @PostMapping("/create")
    @ResponseBody
    public Supervisor create(Supervisor supervisor) {
        return service.create(supervisor);
    }

    @PostMapping("/update")
    @ResponseBody
    public Supervisor update(Supervisor supervisorLevel) {
        return service.update(supervisorLevel);
    }

    @GetMapping("/delete/{level}")
    @ResponseBody
    public void delete(@PathVariable String supervisorLevel) {
        service.delete(supervisorLevel);

    }

    @GetMapping("/read/{level}")
    @ResponseBody
    public Supervisor read(@PathVariable String supervisorLevel) {
        return service.read(supervisorLevel);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Supervisor> getAll() {
        return service.getAll();
    }

}