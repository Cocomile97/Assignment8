package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecture;

import java.util.HashSet;
import java.util.Set;

public interface LectureRepository extends  IRepository<Lecture, String> {
    Set<Lecture> getAll();
}
