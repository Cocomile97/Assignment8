package ac.za.cput.repository;

import ac.za.cput.Repository.AssistantRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.StudentRepository;
import ac.za.cput.Repository.impl.AssistantRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.StudentRepositoryImpl;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Student;
import ac.za.cput.domain.StudentFactory;
import ac.za.cput.factory.AssistantFactory;
import ac.za.cput.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentRepositoryImplTest {

    private StudentRepository repository;
    private Student student;

    private Student getSavedStudent() {
        Set<Student> savedStudents = this.repository.getAll();
        return savedStudents.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StudentRepositoryImpl.getRepository();
        this.student =  StudentFactory.getStudent("","", 99);
    }

    @Test
    public void a_create() {
        Student created = this.repository.create(this.student);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.student);
    }

    @Test
    public void b_read() {
        Student savedStudent = getSavedStudent();
        System.out.println("In read, courseId = "+ savedStudent.getStudentId());
        Student read = this.repository.read(savedStudent.getStudentId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStudent, read);
    }

    @Test
    public void e_delete() {
        Student savedStudent = getSavedStudent();
        this.repository.delete(savedStudent.getStudentId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Student Name";
        Student student = new Student.Builder().copy(getSavedStudent()).studentFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + student);
        Student updated = this.repository.update(student);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getStudentFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Student> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
