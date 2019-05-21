package ac.za.cput.factory;

import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Session;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.StudentFactory;
import org.junit.Assert;
import org.junit.Test;

public class StudentFactoryTest {

    @Test
    public void getStudent() {

        String firstName = "sipho";
        String lastName = "";
        int age = 3;
        Student c = StudentFactory.getStudent(firstName,lastName,age);
        System.out.println(c);
        Assert.assertNotNull(c.getStudentId());
    }
}
