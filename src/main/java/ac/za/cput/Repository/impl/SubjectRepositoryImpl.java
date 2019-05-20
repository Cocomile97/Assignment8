package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.SubjectRepository;
import ac.za.cput.Repository.SupervisorRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Subject;
import ac.za.cput.domain.Supervisor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubjectRepositoryImpl implements SubjectRepository {

    private static SubjectRepositoryImpl repository = null;
    private Set<Subject> subjects;

    private SubjectRepositoryImpl(){
        this.subjects = new HashSet();
    }

    private Subject findSubject(String subjectName) {
        return this.subjects.stream()
                .filter(subject -> subject.getSubjectName().trim().equals(subjectName))
                .findAny()
                .orElse(null);
    }

    public static SubjectRepositoryImpl getRepository(){
        if (repository == null) repository = new SubjectRepositoryImpl();
        return repository;
    }


    public Subject create(Subject subject){
        this.subjects.add(subject);
        return subject;
    }

    public Subject read(final String subjectName){
        Subject subject = findSubject(subjectName);
        return subject;
    }

    public void delete(String subjectName) {
        Subject subject = findSubject(subjectName);
        if (subject != null) this.subjects.remove(subject);
    }

    public Subject update(Subject subject){
        Subject toDelete = findSubject(subject.getSubjectName());
        if(toDelete != null) {
            this.subjects.remove(toDelete);
            return create(subject);
        }
        return null;
    }


    public Set<Subject> getAll(){
        return this.subjects;
    }
}
