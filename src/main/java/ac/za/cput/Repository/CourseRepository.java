package ac.za.cput.Repository;

import ac.za.cput.domain.Course;

import java.util.HashSet;
import java.util.Set;

import java.util.Set;

public interface CourseRepository extends IRepository<Course, String> {
    Set<Course> getAll();
}