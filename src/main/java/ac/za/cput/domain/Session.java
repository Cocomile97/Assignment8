package ac.za.cput.domain;



public class Session {

    private String sessionDuration, sessionType;

    private Session() {
    }

    private Session(Builder builder) {
        this.sessionDuration = builder.sessionDuration;
        this.sessionType = builder.sessionType;
    }

    public String getsessionDuration() {
        return sessionDuration;
    }

    public String getsessionType() {
        return sessionType;
    }

    public static class Builder{

        private String sessionDuration, sessionType;

        public Builder sessionDuration(String sessionDuration) {
            this.sessionDuration = sessionDuration;
            return this;
        }

        public Builder sessionType(String sessionType) {
            this.sessionType = sessionType;
            return this;
        }

        public Session build() {
            return new Session(this);
        }
    }

    @Override
    public String toString() {
        return "Session{" +
                "sessionDuration='" + sessionDuration + '\'' +
                ", sessionType='" + sessionType + '\'' +
                '}';
    }
}