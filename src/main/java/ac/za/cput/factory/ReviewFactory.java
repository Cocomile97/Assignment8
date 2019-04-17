package ac.za.cput.factory;

import ac.za.cput.domain.Review;

public class ReviewFactory {


    public static Review getReview(String reviewName,String id) {
        return new Review.Builder().reviewId(id)
                .reviewName(reviewName)
                .build();
    }
}

