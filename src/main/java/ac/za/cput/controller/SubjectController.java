package ac.za.cput.controller;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Subject;
import ac.za.cput.domain.Year;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.SubjectService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    @Qualifier("ServiceImpl")
    private SubjectService service;

    @PostMapping("/create")
    @ResponseBody
    public Subject create(Subject subject) {
        return service.create(subject);
    }

    @PostMapping("/update")
    @ResponseBody
    public Subject update(Subject subject) {
        return service.update(subject);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String subjectName) {
        service.delete(subjectName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Subject read(@PathVariable String subjectName) {
        return service.read(subjectName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Subject> getAll() {
        return service.getAll();
    }

}