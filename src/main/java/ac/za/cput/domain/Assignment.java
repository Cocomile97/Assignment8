package ac.za.cput.domain;



public class Assignment {

    private String assignmentId, assignmentName;

    private Assignment() {
    }

    private Assignment(Builder builder) {
        this.assignmentId = builder.assignmentId;
        this.assignmentName = builder.assignmentName;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public static class Builder{

        private String assignmentId, assignmentName;

        public Builder assignmentId(String assignmentId) {
            this.assignmentId = assignmentId;
            return this;
        }

        public Builder assignmentName(String assignmentName) {
            this.assignmentName = assignmentName;
            return this;
        }

        public Assignment build() {
            return new Assignment(this);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                '}';
    }
}