package ac.za.cput.controller;
import ac.za.cput.domain.Review;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.Year;
import ac.za.cput.service.ReviewService;
import ac.za.cput.service.StudentService;
import ac.za.cput.service.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    @Qualifier("ServiceImpl")
    private ReviewService service;

    @PostMapping("/create")
    @ResponseBody
    public Review create(Review review) {
        return service.create(review);
    }

    @PostMapping("/update")
    @ResponseBody
    public Review update(Review review) {
        return service.create(review);
    }

    @GetMapping("/delete/{name}")
    @ResponseBody
    public void delete(@PathVariable String reviewName) {
        service.delete(reviewName);

    }

    @GetMapping("/read/{name}")
    @ResponseBody
    public Review read(@PathVariable String reviewName) {
        return service.read(reviewName);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Set<Review> getAll() {
        return service.getAll();
    }

}