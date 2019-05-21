package ac.za.cput.controller;
import ac.za.cput.domain.Dept;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.DeptService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    @Qualifier("ServiceImpl")
    private DeptService service;

    @PostMapping("/create")
    @ResponseBody
    public Dept create(Dept dept) {
        return service.create(dept);
    }

    @PostMapping("/update")
    @ResponseBody
    public Dept update(Dept dept) {
        return service.create(dept);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String deptName) {
        service.delete(deptName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Dept read(@PathVariable String deptName) {
        return service.read(deptName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Dept> getAll() {
        return service.getAll();
    }

}