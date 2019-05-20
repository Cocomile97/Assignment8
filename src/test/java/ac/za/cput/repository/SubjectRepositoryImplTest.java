package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SubjectRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SubjectRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Subject;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.SubjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubjectRepositoryImplTest {

    private SubjectRepository repository;
    private Subject subject;

    private Subject getSavedSubject() {
        Set<Subject> savedSubjects = this.repository.getAll();
        return savedSubjects.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SubjectRepositoryImpl.getRepository();
        this.subject =  SubjectFactory.getSubject("Test Course","");
    }

    @Test
    public void a_create() {
        Subject created = this.repository.create(this.subject);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void b_read() {
        Subject savedSubject = getSavedSubject();
        System.out.println("In read, courseId = "+ savedSubject.getSubjectName());
        Subject read = this.repository.read(savedSubject.getSubjectName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSubject, read);
    }

    @Test
    public void e_delete() {
        Subject savedSubject = getSavedSubject();
        this.repository.delete(savedSubject.getSubjectName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Subject subject = new Subject.Builder().copy(getSavedSubject()).subjectName(newname).build();
        System.out.println("In update, about_to_updated = " + subject);
        Subject updated = this.repository.update(subject);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSubjectName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Subject> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
