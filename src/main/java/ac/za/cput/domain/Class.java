package ac.za.cput.domain;

public class Class {

    private String classId, className;

    private Class(){}

    private Class(Builder builder) {
        this.classId = builder.classId;
        this.className = builder.className;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }
    public static class Builder{

        private String classId, className;

        public Builder classId(String classId) {
            this.classId = classId;
            return this;
        }

        public Builder className(String className) {
            this.className = className;
            return this;
        }

        public Class build() {
            return new Class(this);
        }

    }
    @Override
    public String toString() {
        return "Class{" +
                "classId='" + classId + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
