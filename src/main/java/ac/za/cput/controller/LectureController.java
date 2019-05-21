package ac.za.cput.controller;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.LectureService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lecture")
public class LectureController {
    @Autowired
    @Qualifier("ServiceImpl")
    private LectureService service;

    @PostMapping("/create")
    @ResponseBody
    public Lecture create(Lecture year) {
        return service.create(year);
    }

    @PostMapping("/update")
    @ResponseBody
    public Lecture update(Lecture year) {
        return service.create(year);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String lectureName) {
        service.delete(lectureName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Lecture read(@PathVariable String lectureName) {
        return service.read(lectureName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Lecture> getAll() {
        return service.getAll();
    }

}