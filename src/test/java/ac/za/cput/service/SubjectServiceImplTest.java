package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SubjectRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Review;
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
public class SubjectServiceImplTest {

    private SubjectRepositoryImpl repository;
    private Subject subject;

    private Subject getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SubjectRepositoryImpl.getRepository();
        this.subject = SubjectFactory.getSubject("","");
    }

    @Test
    public void a_create() {
        Subject created = this.repository.create(this.subject);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.subject);
    }

    @Test
    public void c_update() {
        String newSubjectName = "Application";
        Subject updated = new Subject.Builder().copy(getSaved()).subjectName(newSubjectName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSubjectName, updated.getSubjectName());
    }

    @Test
    public void e_delete() {
        Subject saved = getSaved();
        this.repository.delete(saved.getSubjectName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Subject saved = getSaved();
        Subject read = this.repository.read(saved.getSubjectName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Subject> subjects = this.repository.getAll();
        System.out.println("In getall, all = " + subjects);
    }
}