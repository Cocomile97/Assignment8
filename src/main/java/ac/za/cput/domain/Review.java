package ac.za.cput.domain;



public class Review {

    private String reviewId, reviewName;

    private Review() {
    }

    private Review(Builder builder) {
        this.reviewId = builder.reviewId;
        this.reviewName = builder.reviewName;
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public static class Builder{

        private String reviewId, reviewName;

        public Builder reviewId(String reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder reviewName(String reviewName) {
            this.reviewName = reviewName;
            return this;
        }

        public Review build() {
            return new Review(this);
        }
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId='" + reviewId + '\'' +
                ", reviewName='" + reviewName + '\'' +
                '}';
    }
}