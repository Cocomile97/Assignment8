package ac.za.cput.factory;

import ac.za.cput.domain.Subject;
import org.junit.Assert;
import org.junit.Test;

public class SubjectFactoryTest {

    @Test
    public void getSubject() {

        String name = "Information Systems";
        String id="ITS2";
        Subject a = SubjectFactory.getSubject(name,id);
        System.out.println(a);
        Assert.assertEquals( "ITS2",a.getSubjectId());
    }
}
