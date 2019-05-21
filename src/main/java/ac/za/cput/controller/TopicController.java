package ac.za.cput.controller;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Topic;
import ac.za.cput.domain.Year;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.TopicService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/topic")
public class TopicController {
    @Autowired
    @Qualifier("ServiceImpl")
    private TopicService service;

    @PostMapping("/create")
    @ResponseBody
    public Topic create(Topic topic) {
        return service.create(topic);
    }

    @PostMapping("/update")
    @ResponseBody
    public Topic update(Topic topic) {
        return service.update(topic);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String topicName) {
        service.delete(topicName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Topic read(@PathVariable String topicName) {
        return service.read(topicName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Topic> getAll() {
        return service.getAll();
    }

}