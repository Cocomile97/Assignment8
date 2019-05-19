package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LectureRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LectureRepositoryImpl implements LectureRepository {

    private static LectureRepositoryImpl repository = null;
    private Set<Lecture> lectures;

    private LectureRepositoryImpl(){
        this.lectures = new HashSet();
    }

    private Lecture findLecture(String lectureName) {
        return this.lectures.stream()
                .filter(lecture -> lecture.getLectureName().trim().equals(lectureName))
                .findAny()
                .orElse(null);
    }

    public static LectureRepositoryImpl getRepository(){
        if (repository == null) repository = new LectureRepositoryImpl();
        return repository;
    }


    public Lecture create(Lecture lecture){
        this.lectures.add(lecture);
        return lecture;
    }

    public Lecture read(final String lectureName){
        Lecture lecture = findLecture(lectureName);
        return lecture;
    }

    public void delete(String lectureName) {
        Lecture lecture = findLecture(lectureName);
        if (lecture != null) this.lectures.remove(lecture);
    }

    public Lecture update(Lecture lecture){
        Lecture toDelete = findLecture(lecture.getLectureName());
        if(toDelete != null) {
            this.lectures.remove(toDelete);
            return create(lecture);
        }
        return null;
    }


    public Set<Lecture> getAll(){
        return this.lectures;
    }
}
