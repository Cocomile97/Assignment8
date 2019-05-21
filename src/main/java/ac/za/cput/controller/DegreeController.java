package ac.za.cput.controller;
import ac.za.cput.domain.Degree;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.DegreeService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/degree")
public class DegreeController {
    @Autowired
    @Qualifier("ServiceImpl")
    private DegreeService service;

    @PostMapping("/create")
    @ResponseBody
    public Degree create(Degree degree) {
        return service.create(degree);
    }

    @PostMapping("/update")
    @ResponseBody
    public Degree update
            (Degree degree) {
        return service.create(degree);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String degreeName) {
        service.delete(degreeName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Degree read(@PathVariable String degreeName) {
        return service.read(degreeName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Degree> getAll() {
        return service.getAll();
    }

}