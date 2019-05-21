package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LectureRepositoryImpl;
import ac.za.cput.Repository.impl.LecturerRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecturer;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.LecturerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LecturerServiceImplTest {

    private LecturerRepositoryImpl repository;
    private Lecturer lecturer;

    private Lecturer getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LecturerRepositoryImpl.getRepository();
        this.lecturer = LecturerFactory.getLecturer("","",33);
    }

    @Test
    public void a_create() {
        Lecturer created = this.repository.create(this.lecturer);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.lecturer);
    }

    @Test
    public void c_update() {
        String newLecturerName = "Dr Kabaso";
        Lecturer updated = new Lecturer.Builder().copy(getSaved()).lecturerFirstName(newLecturerName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newLecturerName, updated.getLecturerFirstName());
    }

    @Test
    public void e_delete() {
        Lecturer saved = getSaved();
        this.repository.delete(saved.getLecturerFirstName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Lecturer saved = getSaved();
        Lecturer read = this.repository.read(saved.getLecturerFirstName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Lecturer> lecturers = this.repository.getAll();
        System.out.println("In getall, all = " + lecturers);
    }
}