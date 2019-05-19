package ac.za.cput.factory;

import ac.za.cput.domain.Lecture;
import ac.za.cput.util.Misc;

public class LectureFactory {


    public static Lecture getLecture(String lectureName, String lectureNum, String lectureType) {

        return new Lecture.Builder().lectureName(lectureName)
                .lectureNum(lectureNum)
                .lectureType(lectureType)
                .build();
    }
}