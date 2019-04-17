package ac.za.cput.factory;

import ac.za.cput.domain.Subject;
import ac.za.cput.util.Misc;

public class SubjectFactory {


    public static Subject getSubject(String subjectName,String id) {
        return new Subject.Builder().subjectId(id)
                .subjectName(subjectName)
                .build();
    }
}
