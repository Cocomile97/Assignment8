package ac.za.cput.factory;

import ac.za.cput.domain.Review;
import junit.framework.Assert;
import org.junit.Test;

public class ReviewFactoryTest {

    @Test
    public void getReview() {

        String name = "Exercises";
        String id="1A";
        Review a = ReviewFactory.getReview(name,id);
        System.out.println(a);
        Assert.assertEquals( "1A",a.getReviewId());
    }
}
