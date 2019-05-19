package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.ReviewRepository;
import ac.za.cput.domain.Project;
import ac.za.cput.domain.Review;
import java.util.HashSet;
import java.util.Set;

public class ReviewRepositoryImpl implements ReviewRepository {

    private static ReviewRepositoryImpl repository = null;
    private Set<Review> reviews;

    private ReviewRepositoryImpl() {
        this.reviews = new HashSet();
    }

    private Review findReview(String reviewId) {
        return this.reviews.stream()
                .filter(review -> review.getReviewId().trim().equals(reviewId))
                .findAny()
                .orElse(null);
    }

    public static ReviewRepositoryImpl getRepository() {
        if (repository == null) repository = new ReviewRepositoryImpl();
        return repository;
    }


    public Review create(Review review) {
        this.reviews.add(review);
        return review;
    }

    public Review read(final String reviewId) {
        Review review = findReview(reviewId);
        return review;
    }

    public void delete(String reviewId) {
        Review review = findReview(reviewId);
        if (review != null) this.reviews.remove(review);
    }

    public Review update(Review review){
        Review toDelete = findReview(review.getReviewId());
        if(toDelete != null) {
            this.reviews.remove(toDelete);
            return create(review);
        }
        return null;
    }


    public Set<Review> getAll(){
        return this.reviews;
    }
}
