package ac.za.cput.factory;

import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Stream;
import org.junit.Assert;
import org.junit.Test;

public class AssistantFactoryTest {

    @Test
    public void getAssistant() {

        String firstName = "sipho";
        String lastName = "";
        int age = 3;
        Assistant c = AssistantFactory.getAssistant(firstName,lastName,age);
        System.out.println(c);
        Assert.assertNotNull(c.getAssistanttId());
    }
}
