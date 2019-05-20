package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SupervisorRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SupervisorRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Supervisor;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.SupervisorFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SupervisorRepositoryImplTest {

    private SupervisorRepository repository;
    private Supervisor supervisor;

    private Supervisor getSavedSupervisor() {
        Set<Supervisor> savedSupervisors = this.repository.getAll();
        return savedSupervisors.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupervisorRepositoryImpl.getRepository();
        this.supervisor =  SupervisorFactory.getSupervisor("Test Level","Test Name");
    }

    @Test
    public void a_create() {
        Supervisor created = this.repository.create(this.supervisor);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.supervisor);
    }

    @Test
    public void b_read() {
        Supervisor savedSupervisor = getSavedSupervisor();
        System.out.println("In read, courseId = "+ savedSupervisor.getSupervisorName());
        Supervisor read = this.repository.read(savedSupervisor.getSupervisorName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSupervisor, read);
    }

    @Test
    public void e_delete() {
        Supervisor savedSupervisor = getSavedSupervisor();
        this.repository.delete(savedSupervisor.getSupervisorName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Supervisor supervisor = new Supervisor.Builder().copy(getSavedSupervisor()).supervisorName(newname).build();
        System.out.println("In update, about_to_updated = " + supervisor);
        Supervisor updated = this.repository.update(supervisor);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getSupervisorName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Supervisor> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
