package ac.za.cput.controller;
import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.AssignmentService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {
    @Autowired
    @Qualifier("ServiceImpl")
    private AssignmentService service;

    @PostMapping("/create")
    @ResponseBody
    public Assignment create(Assignment assignment) {
        return service.create(assignment);
    }

    @PostMapping("/update")
    @ResponseBody
    public Assignment update(Assignment assignment) {
        return service.create(assignment);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String assignmentName) {
        service.delete(assignmentName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Assignment read(@PathVariable String assignmentName) {
        return service.read(assignmentName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Assignment> getAll() {
        return service.getAll();
    }

}