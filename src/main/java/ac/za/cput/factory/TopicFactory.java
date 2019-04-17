package ac.za.cput.factory;

import ac.za.cput.domain.Topic;
import ac.za.cput.util.Misc;

public class TopicFactory {


    public static Topic getTopic(String topicName) {

        return new Topic.Builder().topicName(topicName)
                .build();
    }
}