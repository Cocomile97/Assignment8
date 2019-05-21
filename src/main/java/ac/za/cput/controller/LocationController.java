package ac.za.cput.controller;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.LocationService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    @Qualifier("ServiceImpl")
    private LocationService service;

    @PostMapping("/create")
    @ResponseBody
    public Location create(Location location) {
        return service.create(location);
    }

    @PostMapping("/update")
    @ResponseBody
    public Location update(Location location) {
        return service.create(location);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String locationName) {
        service.delete(locationName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Location read(@PathVariable String locationName) {
        return service.read(locationName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Location> getAll() {
        return service.getAll();
    }

}