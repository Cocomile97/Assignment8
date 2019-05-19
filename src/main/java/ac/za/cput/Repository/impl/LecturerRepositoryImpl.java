package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LecturerRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecturer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LecturerRepositoryImpl implements LecturerRepository {

    private static LecturerRepositoryImpl repository = null;
    private Set<Lecturer> lecturers;

    private LecturerRepositoryImpl(){
        this.lecturers = new HashSet();
    }

    private Lecturer findLecturer(String lecturerId) {
        return this.lecturers.stream()
                .filter(lecturer -> lecturer.getLecturerId().trim().equals(lecturerId))
                .findAny()
                .orElse(null);
    }

    public static LecturerRepositoryImpl getRepository(){
        if (repository == null) repository = new LecturerRepositoryImpl();
        return repository;
    }


    public Lecturer create(Lecturer lecturer){
        this.lecturers.add(lecturer);
        return lecturer;
    }

    public Lecturer read(final String lecturerId){
        Lecturer lecturer = findLecturer(lecturerId);
        return lecturer;
    }

    public void delete(String lecturerId) {
        Lecturer lecturer = findLecturer(lecturerId);
        if (lecturer != null) this.lecturers.remove(lecturer);
    }

    public Lecturer update(Lecturer lecturer){
        Lecturer toDelete = findLecturer(lecturer.getLecturerId());
        if(toDelete != null) {
            this.lecturers.remove(toDelete);
            return create(lecturer);
        }
        return null;
    }


    public Set<Lecturer> getAll(){
        return this.lecturers;
    }
}
