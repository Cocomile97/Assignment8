package ac.za.cput.repository;

import ac.za.cput.Repository.AssignmentRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.impl.AssignmentRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Course;
import ac.za.cput.factory.AssignmentFactory;
import ac.za.cput.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssignmentRepositoryImplTest {

    private AssignmentRepository repository;
    private Assignment assignment;

    private Assignment getSavedAssignment() {
        Set<Assignment> savedAssignment = this.repository.getAll();
        return savedAssignment.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssignmentRepositoryImpl.getRepository();
        this.assignment =  AssignmentFactory.getAssignment("Test Course","");
    }

    @Test
    public void a_create() {
        Assignment created = this.repository.create(this.assignment);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.assignment);
    }

    @Test
    public void b_read() {
        Assignment savedAssignment = getSavedAssignment();
        System.out.println("In read, courseId = "+ savedAssignment.getAssignmentId());
        Assignment read = this.repository.read(savedAssignment.getAssignmentId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAssignment, read);
    }

    @Test
    public void e_delete() {
        Assignment savedAssignment = getSavedAssignment();
        this.repository.delete(savedAssignment.getAssignmentId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Assignment assignment = new Assignment.Builder().copy(getSavedAssignment()).assignmentName(newname).build();
        System.out.println("In update, about_to_updated = " + assignment);
        Assignment updated = this.repository.update(assignment);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getAssignmentName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assignment> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
