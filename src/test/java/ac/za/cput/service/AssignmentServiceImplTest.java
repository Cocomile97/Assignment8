package ac.za.cput.service;

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
public class AssignmentServiceImplTest {

    private AssignmentRepositoryImpl repository;
    private Assignment assignment;

    private Assignment getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssignmentRepositoryImpl.getRepository();
        this.assignment = AssignmentFactory.getAssignment("","");
    }

    @Test
    public void a_create() {
        Assignment created = this.repository.create(this.assignment);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.assignment);
    }

    @Test
    public void c_update() {
        String newAssignmentName = "Assignment Designs";
        Assignment updated = new Assignment.Builder().copy(getSaved()).assignmentName(newAssignmentName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAssignmentName, updated.getAssignmentName());
    }

    @Test
    public void e_delete() {
        Assignment saved = getSaved();
        this.repository.delete(saved.getAssignmentName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Assignment saved = getSaved();
        Assignment read = this.repository.read(saved.getAssignmentName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Assignment> assignments = this.repository.getAll();
        System.out.println("In getall, all = " + assignments);
    }
}