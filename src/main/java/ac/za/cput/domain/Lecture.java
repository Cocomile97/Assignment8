package ac.za.cput.domain;



public class Lecture {

    private String lectureNum, lectureName, lectureType;

    private Lecture() {
    }

    private Lecture(Builder builder) {
        this.lectureNum = builder.lectureNum;
        this.lectureName = builder.lectureName;
        this.lectureType = builder.lectureType;
    }

    public String getLectureNum() {
        return lectureNum;
    }

    public String getLectureName() {
        return lectureName;
    }

    public String getLectureType() {
        return lectureType;
    }

    public static class Builder{

        private String lectureNum, lectureName, lectureType;


        public Builder lectureNum(String lectureNum) {
            this.lectureNum = lectureNum;
            return this;
        }

        public Builder lectureName(String lectureName) {
            this.lectureName = lectureName;
            return this;
        }

        public Builder lectureType(String lectureType) {
            this.lectureType = lectureType;
            return this;
        }
        public Lecture.Builder copy (Lecture lecture){
            this.lectureName = lecture.lectureName;
            this.lectureNum = lecture.lectureNum;
            this.lectureType = lecture.lectureType;


            return this;
        }
        public Lecture build() {
            return new Lecture(this);
        }
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "lectureNum='" + lectureNum + '\'' +
                ", lectureName='" + lectureName + '\'' +
                ", lectureType='" + lectureType + '\'' +
                '}';
    }
}