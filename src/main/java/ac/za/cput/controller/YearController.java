package ac.za.cput.controller;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/student")
public class YearController {
    @Autowired
    @Qualifier("ServiceImpl")
    private YearService service;

    @PostMapping("/create")
    @ResponseBody
    public Year create(Year year) {
        return service.create(year);
    }

    @PostMapping("/update")
    @ResponseBody
    public Year update(Year year) {
        return service.update(year);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String yearNum) {
        service.delete(yearNum);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Year read(@PathVariable String yearNum) {
        return service.read(yearNum);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Year> getAll() {
        return service.getAll();
    }

}