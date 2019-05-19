package ac.za.cput.factory;

import ac.za.cput.domain.Lecture;
import org.junit.Assert;
import org.junit.Test;

public class LectureFactoryTest {

    @Test
    public void getLecture() {

        String num= "1";
        String type = "quiz";
        String name = "Sess";
        Lecture c = LectureFactory.getLecture(num,type,name);
        System.out.println(c);
        Assert.assertNotNull(c.getLectureName());
        Assert.assertNotNull(c.getLectureNum());
        Assert.assertNotNull(c.getLectureType());
    }
}
