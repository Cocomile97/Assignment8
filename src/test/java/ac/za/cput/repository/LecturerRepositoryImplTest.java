package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LecturerRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LecturerRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Lecturer;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.LectureFactory;
import ac.za.cput.factory.LecturerFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LecturerRepositoryImplTest {

    private LecturerRepository repository;
    private Lecturer lecturer;

    private Lecturer getSavedLecturer() {
        Set<Lecturer> savedLecturers = this.repository.getAll();
        return savedLecturers.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LecturerRepositoryImpl.getRepository();
        this.lecturer =  LecturerFactory.getLecturer("","",56);
    }

    @Test
    public void a_create() {
        Lecturer created = this.repository.create(this.lecturer);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.lecturer);
    }

    @Test
    public void b_read() {
        Lecturer savedLecturer = getSavedLecturer();
        System.out.println("In read, courseId = "+ savedLecturer.getLecturerId());
        Lecturer read = this.repository.read(savedLecturer.getLecturerId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedLecturer, read);
    }

    @Test
    public void e_delete() {
        Lecturer savedLecturer = getSavedLecturer();
        this.repository.delete(savedLecturer.getLecturerId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Lecturer lecturer = new Lecturer.Builder().copy(getSavedLecturer()).lecturerFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + lecturer);
        Lecturer updated = this.repository.update(lecturer);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getLecturerId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Lecturer> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
