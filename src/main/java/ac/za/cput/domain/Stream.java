package ac.za.cput.domain;



public class Stream {

    private String streamId, streamName;

    private Stream() {
    }

    private Stream(Builder builder) {
        this.streamId = builder.streamId;
        this.streamName = builder.streamName;
    }

    public String getStreamId() {
        return streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public static class Builder{

        private String streamId, streamName;

        public Builder streamId(String streamId) {
            this.streamId = streamId;
            return this;
        }

        public Builder streamName(String streamName) {
            this.streamName = streamName;
            return this;
        }

        public Stream.Builder copy (Stream stream){
            this.streamId= stream.streamId;
            this.streamName = stream.streamName;

            return this;
        }
        public Stream build() {
            return new Stream(this);
        }
    }

    @Override
    public String toString() {
        return "Stream{" +
                "streamId='" + streamId + '\'' +
                ", streamName='" + streamName + '\'' +
                '}';
    }
}