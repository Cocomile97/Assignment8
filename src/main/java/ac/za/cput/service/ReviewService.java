package ac.za.cput.service;

import ac.za.cput.domain.Review;

import java.util.Set;

public interface ReviewService extends IService<Review, String> {
    Set<Review> getAll();
}
