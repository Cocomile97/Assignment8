package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.ReviewRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.ReviewRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Review;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReviewServiceImpl implements ReviewService {

    private static ReviewServiceImpl service = null;
    private ReviewRepository repository;

    private ReviewServiceImpl() {
        this.repository = ReviewRepositoryImpl.getRepository();
    }

    public static ReviewServiceImpl getService(){
        if (service == null) service = new ReviewServiceImpl();
        return service;
    }

    @Override
    public Review create(Review review) {
        return this.repository.create(review);
    }

    @Override
    public Review update(Review review) {
        return this.repository.update(review);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Review read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Review> getAll() {
        return this.repository.getAll();
    }
}