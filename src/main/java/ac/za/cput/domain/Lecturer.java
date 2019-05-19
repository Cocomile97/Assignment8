package ac.za.cput.domain;



public class Lecturer {

    private String lecturerId, lecturerFirstName, lecturerLastName;
    private int age;

    private Lecturer(){}

    private Lecturer(Builder builder) {
        this.lecturerId = builder.lecturerId;
        this.age = builder.age;
        this.lecturerFirstName = builder.lecturerFirstName;
        this.lecturerLastName = builder.lecturerLastName;
    }

    public String getLecturerId() {
        return lecturerId;
    }

    public String getLecturerFirstName() {
        return lecturerFirstName;
    }

    public String getLecturerLastName() {
        return lecturerLastName;
    }

    public int getAge() {
        return age;
    }

    public static class Builder {

        private String lecturerId, lecturerFirstName, lecturerLastName;
        private int age;

        public Builder lecturerId( String lecturerId) {
            this.lecturerId = lecturerId;
            return this;
        }

        public Builder lecturerFirstName( String lecturerFirstName) {
            this.lecturerFirstName = lecturerFirstName;
            return this;
        }

        public Builder lecturerLastName( String lecturerLastName) {
            this.lecturerLastName = lecturerLastName;
            return this;
        }

        public Builder age( int age) {
            this.age = age;
            return this;
        }

        public Lecturer.Builder copy (Lecturer lecturer){
            this.lecturerFirstName = lecturer.lecturerFirstName;
            this.lecturerLastName = lecturer.lecturerLastName;
            this.lecturerId = lecturer.lecturerId;
            this. age = lecturer.age;


            return this;
        }
        public Lecturer build() {
            return new Lecturer(this);
        }

    }

    @Override
    public String toString() {
        return "LecturerFactory{" +
                "lecturerId='" + lecturerId + '\'' +
                ", lecturerFirstName='" + lecturerFirstName + '\'' +
                ", lecturerLastName='" + lecturerLastName + '\'' +
                ", age=" + age +
                '}';
    }
}