package ac.za.cput.controller;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Student;
import ac.za.cput.service.AssistantService;
import ac.za.cput.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/assistant")
public class AssistantController {
    @Autowired
    @Qualifier("ServiceImpl")
    private AssistantService service;

    @PostMapping("/create")
    @ResponseBody
    public Assistant create(Assistant assistant) {
        return service.create(assistant);
    }

    @PostMapping("/update")
    @ResponseBody
    public Assistant update(Assistant assistant) {
        return service.update(assistant);
    }

    @GetMapping("/delete/{firstName}")
    @ResponseBody
    public void delete(@PathVariable String assistantFirstName) {
        service.delete(assistantFirstName);

    }

    @GetMapping("/read/{firstName}")
    @ResponseBody
    public Assistant read(@PathVariable String assistantFirstName) {
        return service.read(assistantFirstName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Assistant> getAll() {
        return service.getAll();
    }

}