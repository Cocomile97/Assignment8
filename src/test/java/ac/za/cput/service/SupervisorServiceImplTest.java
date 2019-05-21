package ac.za.cput.service;

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
public class SupervisorServiceImplTest {

    private SupervisorRepositoryImpl repository;
    private Supervisor supervisor;

    private Supervisor getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SupervisorRepositoryImpl.getRepository();
        this.supervisor = SupervisorFactory.getSupervisor("","");
    }

    @Test
    public void a_create() {
        Supervisor created = this.repository.create(this.supervisor);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.supervisor);
    }

    @Test
    public void c_update() {
        String newSupervisorLevel = "Masters Level";
        Supervisor updated = new Supervisor.Builder().copy(getSaved()).supervisorLevel(newSupervisorLevel).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSupervisorLevel, updated.getsupervisorLevel());
    }

    @Test
    public void e_delete() {
        Supervisor saved = getSaved();
        this.repository.delete(saved.getsupervisorLevel());
        d_getAll();
    }

    @Test
    public void b_read() {
        Supervisor saved = getSaved();
        Supervisor read = this.repository.read(saved.getsupervisorLevel());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Supervisor> supervisors = this.repository.getAll();
        System.out.println("In getall, all = " + supervisors);
    }
}