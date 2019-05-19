package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LectureRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LectureRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.LectureFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LectureRepositoryImplTest {

    private LectureRepository repository;
    private Lecture lecture;

    private Lecture getSavedLecture() {
        Set<Lecture> savedLectures = this.repository.getAll();
        return savedLectures.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = LectureRepositoryImpl.getRepository();
        this.lecture =  LectureFactory.getLecture("","", "");
    }

    @Test
    public void a_create() {
        Lecture created = this.repository.create(this.lecture);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.lecture);
    }

    @Test
    public void b_read() {
        Lecture savedLecture = getSavedLecture();
        System.out.println("In read, courseId = "+ savedLecture.getLectureName());
        Lecture read = this.repository.read(savedLecture.getLectureName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedLecture, read);
    }

    @Test
    public void e_delete() {
        Lecture savedLecture = getSavedLecture();
        this.repository.delete(savedLecture.getLectureName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Lecture lecture = new Lecture.Builder().copy(getSavedLecture()).lectureName(newname).build();
        System.out.println("In update, about_to_updated = " + lecture);
        Lecture updated = this.repository.update(lecture);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getLectureName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Lecture> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
