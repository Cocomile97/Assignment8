package ac.za.cput.domain;

public class Subject {

    private String subjectId, subjectName;

    private Subject(){}
    private Subject(Builder builder) {
        this.subjectId = builder.subjectId;
        this.subjectName = builder.subjectName;
    }

    public String getSubjectId() {
        return subjectId;
    }
    public String getSubjectName() {
        return subjectName;
    }

    public static class Builder{

        private String subjectId, subjectName;

        public Builder subjectId(String subjectId) {
            this.subjectId = subjectId;
            return this;
        }

        public Builder subjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Subject build() {
            return new Subject(this);
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectId='" + subjectId + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}

