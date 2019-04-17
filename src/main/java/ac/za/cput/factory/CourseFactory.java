package ac.za.cput.factory;

import ac.za.cput.domain.Course;
import ac.za.cput.util.Misc;

public class CourseFactory {


    public static Course getCourse(String courseName) {
        return new Course.Builder().courseId(Misc.generateId())
                .courseName(courseName)
                .build();
    }
}

