package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.ReviewRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Review;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.ReviewFactory;
import ac.za.cput.service.impl.ReviewServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReviewServiceImplTest {

    private ReviewRepositoryImpl repository;
    private Review review;

    private Review getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ReviewRepositoryImpl.getRepository();
        this.review = ReviewFactory.getReview("","");
    }
    @Test
    public void a_create() {
        Review created = this.repository.create(this.review);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.review);
    }

    @Test
    public void c_update() {
        String newReviewName = "Review Test";
        Review updated = new Review.Builder().copy(getSaved()).reviewName(newReviewName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newReviewName, updated.getReviewName());
    }

    @Test
    public void e_delete() {
        Review saved = getSaved();
        this.repository.delete(saved.getReviewName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Review saved = getSaved();
        Review read = this.repository.read(saved.getReviewName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Review> courses = this.repository.getAll();
        System.out.println("In getall, all = " + review);
    }
}