package ac.za.cput.controller;
import ac.za.cput.domain.Office;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.OfficeService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    @Qualifier("ServiceImpl")
    private OfficeService service;

    @PostMapping("/create")
    @ResponseBody
    public Office create(Office office) {
        return service.create(office);
    }

    @PostMapping("/update")
    @ResponseBody
    public Office update(Office office) {
        return service.create(office);
    }

    @GetMapping("/delete/{num}")
    @ResponseBody
    public void delete(@PathVariable String officeNum) {
        service.delete(officeNum);

    }

    @GetMapping("/read/{num}")
    @ResponseBody
    public Office read(@PathVariable String officeNum) {
        return service.read(officeNum);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Office> getAll() {
        return service.getAll();
    }

}