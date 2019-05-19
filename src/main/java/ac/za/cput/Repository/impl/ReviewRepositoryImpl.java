package ac.za.cput.Repository.impl;
import ac.za.cput.Repository.ReviewRepository;
import ac.za.cput.domain.Review;
import ac.za.cput.factory.ReviewFactory;

import java.util.*;


public class ReviewRepositoryImpl implements ReviewRepository {

    private List <Review>listreview;

    private static ReviewRepositoryImpl repository = null;
    private Set<Review> review;

    private ReviewRepositoryImpl (){
        this.review = new HashSet<Review>();
    }

    public static ReviewRepositoryImpl getRepository(){
        if (repository == null) repository = new ReviewRepositoryImpl();
        return repository;
    }


    public Set<Review> getAll() {
        return review;
    }


    public Review create(Review review) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the review id: ");
        String id=input.nextLine().toUpperCase();
        System.out.println("Enter the review name : ");
        String name=input.nextLine();


        review=ReviewFactory.getReview(id,name);

        this.review.add(review);
        System.out.println("Review created successfully");

        return review;
    }

    @Override
    public Review update(Review review) {
        return null;
    }

    @Override
    public void delete(String s) {

        listreview=new ArrayList<Review>(review);
        for (int i=0;i<listreview.size();i++){
            if (s.toUpperCase()==listreview.get(i).getReviewId() ){
                review.remove(i);
            }
        }
        for(Review b : listreview)
            review.add(b);
    }

    @Override
    public Review read(String s) {
        Review b=null;
        listreview=new ArrayList<Review>(review);
        for (int i=0;i<listreview.size();i++){
            if (s==listreview.get(i).getReviewId() ){
                b= listreview.get(i);
            }
        }
        return b;
    }
}
