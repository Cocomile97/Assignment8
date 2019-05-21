package ac.za.cput.controller;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    @Qualifier("ServiceImpl")
    private CourseService service;

    @PostMapping("/create")
    @ResponseBody
    public Course create(Course course) {
        return service.create(course);
    }

    @PostMapping("/update")
    @ResponseBody
    public Course update(Course course) {
        return service.create(course);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String courseName) {
        service.delete(courseName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Course read(@PathVariable String courseName) {
        return service.read(courseName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Course> getAll() {
        return service.getAll();
    }

}