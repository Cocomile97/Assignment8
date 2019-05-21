package ac.za.cput.service;

import ac.za.cput.domain.Lecturer;

import java.util.Set;

public interface LecturerService extends IService<Lecturer, String> {
    Set<Lecturer> getAll();
}
