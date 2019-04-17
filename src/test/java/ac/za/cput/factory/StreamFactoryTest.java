package ac.za.cput.factory;

import ac.za.cput.domain.Stream;
import org.junit.Assert;
import org.junit.Test;

public class StreamFactoryTest {

    @Test
    public void getStream() {

        String name = "Multimedia";
        String id="360S";
        Stream a = StreamFactory.getStream(name,id);
        System.out.println(a);
        Assert.assertEquals( "360S",a.getStreamId());
    }
}
