package ac.za.cput.service;

import ac.za.cput.domain.Lecture;

import java.util.Set;

public interface LectureService extends IService<Lecture, String> {
    Set<Lecture> getAll();
}
