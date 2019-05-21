package ac.za.cput.controller;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecturer;
import ac.za.cput.domain.Student;
import ac.za.cput.service.LectureService;
import ac.za.cput.service.LecturerService;
import ac.za.cput.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    @Qualifier("ServiceImpl")
    private LecturerService service;

    @PostMapping("/create")
    @ResponseBody
    public Lecturer create(Lecturer lecturer) {
        return service.create(lecturer);
    }

    @PostMapping("/update")
    @ResponseBody
    public Lecturer update(Lecturer lecturer) {
        return service.update(lecturer);
    }

    @GetMapping("/delete/{firstName}")
    @ResponseBody
    public void delete(@PathVariable String lecturerFirstName) {
        service.delete(lecturerFirstName);

    }

    @GetMapping("/read/{firstName}")
    @ResponseBody
    public Lecturer read(@PathVariable String lecturerFirstName) {
        return service.read(lecturerFirstName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Lecturer> getAll() {
        return service.getAll();
    }

}