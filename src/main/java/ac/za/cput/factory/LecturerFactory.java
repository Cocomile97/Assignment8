package ac.za.cput.factory;

import ac.za.cput.domain.Lecturer;
import ac.za.cput.util.Misc;

public class LecturerFactory {

    public static Lecturer getLecturer(String lecturerLastName, String lecturerFirstName, int age) {
        return new Lecturer.Builder().age(age)
                .lecturerLastName(lecturerLastName)
                .lecturerFirstName(lecturerFirstName)
                .lecturerId(Misc.generateId())
                .build();
    }
}