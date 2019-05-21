package ac.za.cput.controller;
import ac.za.cput.domain.Stream;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.StreamService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/stream")
public class StreamController {
    @Autowired
    @Qualifier("ServiceImpl")
    private StreamService service;

    @PostMapping("/create")
    @ResponseBody
    public Stream create(Stream stream) {
        return service.create(stream);
    }

    @PostMapping("/update")
    @ResponseBody
    public Stream update(Stream stream) {
        return service.create(stream);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String streamName) {
        service.delete(streamName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Stream read(@PathVariable String streamName) {
        return service.read(streamName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Stream> getAll() {
        return service.getAll();
    }

}