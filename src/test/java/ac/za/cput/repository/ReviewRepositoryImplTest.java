package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.ReviewRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.ReviewRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Review;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.ReviewFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReviewRepositoryImplTest {

    private ReviewRepository repository;
    private Review review;

    private Review getSavedReview() {
        Set<Review> savedReviews = this.repository.getAll();
        return savedReviews.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ReviewRepositoryImpl.getRepository();
        this.review =  ReviewFactory.getReview("Test Course","");
    }

    @Test
    public void a_create() {
        Review created = this.repository.create(this.review);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.review);
    }

    @Test
    public void b_read() {
        Review savedReview = getSavedReview();
        System.out.println("In read, courseId = "+ savedReview.getReviewId());
        Review read = this.repository.read(savedReview.getReviewId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedReview, read);
    }

    @Test
    public void e_delete() {
        Review savedReview = getSavedReview();
        this.repository.delete(savedReview.getReviewId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Review review = new Review.Builder().copy(getSavedReview()).reviewId(newname).build();
        System.out.println("In update, about_to_updated = " + review);
        Review updated = this.repository.update(review);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getReviewId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Review> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
