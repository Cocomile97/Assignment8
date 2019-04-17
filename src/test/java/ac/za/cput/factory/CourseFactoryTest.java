package ac.za.cput.factory;

import ac.za.cput.domain.Course;
import org.junit.Assert;
import org.junit.Test;

public class CourseFactoryTest {

    @Test
    public void getCourse() {

        String name = "ADP 3";
        Course c = CourseFactory.getCourse(name);
        System.out.println(c);
        Assert.assertNotNull(c.getCourseId());
    }
}
