package ac.za.cput.factory;

import ac.za.cput.domain.Topic;
import org.junit.Assert;
import org.junit.Test;

public class TopicFactoryTest {

    @Test
    public void getStream() {

        String name = "Databases";
        Topic a = TopicFactory.getTopic(name);
        System.out.println(a);
        Assert.assertNotNull(a.getTopicName());
    }
}
