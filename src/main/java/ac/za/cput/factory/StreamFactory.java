package ac.za.cput.factory;

import ac.za.cput.domain.Stream;
import ac.za.cput.util.Misc;

public class StreamFactory {


    public static Stream getStream(String streamName,String id) {
        return new Stream.Builder().streamId(id)
                .streamName(streamName)
                .build();
    }
}

