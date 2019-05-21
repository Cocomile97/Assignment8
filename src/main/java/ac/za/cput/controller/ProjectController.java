package ac.za.cput.controller;
import ac.za.cput.domain.Project;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.ProjectService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    @Qualifier("ServiceImpl")
    private ProjectService service;

    @PostMapping("/create")
    @ResponseBody
    public Project create(Project project) {
        return service.create(project);
    }

    @PostMapping("/update")
    @ResponseBody
    public Project update(Project project) {
        return service.create(project);
    }


    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String projectName) {
        service.delete(projectName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Project read(@PathVariable String projectName) {
        return service.read(projectName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Project> getAll() {
        return service.getAll();
    }

}