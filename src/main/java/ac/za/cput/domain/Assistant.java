package ac.za.cput.domain;



public class Assistant {

    private String assistantId, assistantFirstName, assistantLastName;
    private int age;

    private Assistant(){}

    private Assistant(Builder builder) {
        this.assistantId = builder.assistantId;
        this.age = builder.age;
        this.assistantFirstName = builder.assistantLastName;
        this.assistantLastName = builder.assistantLastName;
    }

    public String getAssistanttId() {
        return assistantId;
    }

    public String getAssistantFirstName() {
        return assistantFirstName;
    }

    public String getAssistantLastName() {
        return assistantLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private String assistantId, assistantFirstName, assistantLastName;
        private int age;

        public Builder assistantId( String assistantId) {
            this.assistantId = assistantId;
            return this;
        }

        public Builder assistantFirstName( String assistantFirstName) {
            this.assistantFirstName = assistantFirstName;
            return this;
        }

        public Builder assistantLastName( String assistantLastName) {
            this.assistantLastName = assistantLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Assistant.Builder copy (Assistant assistant){
            this.assistantFirstName = assistant.assistantFirstName;
            this.assistantLastName = assistant.assistantLastName;
            this.age= assistant.age;
            this.assistantId= assistant.assistantId;

            return this;
        }
        public Assistant build() {
            return new Assistant(this);
        }

    }

    @Override
    public String toString() {
        return "Assistant{" +
                "assistantId='" + assistantId + '\'' +
                ", assistantLastName='" + assistantLastName + '\'' +
                ", assistantFirstName='" + assistantFirstName + '\'' +
                ", age=" + age +
                '}';
    }
}