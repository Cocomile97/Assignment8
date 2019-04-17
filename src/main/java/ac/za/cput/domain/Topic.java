package ac.za.cput.domain;

public class Topic {

    private String topicName;

    private Topic(){}
    private Topic(Builder builder) {
        this.topicName = builder.topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public static class Builder{

        private String topicName;


        public Builder topicName(String topicName) {
            this.topicName = topicName;
            return this;
        }

        public Topic build() {
            return new Topic(this);
        }
    }

    @Override
    public String toString() {
        return "Topic{" +
                ", topicName='" + topicName + '\'' +
                '}';
    }
}

