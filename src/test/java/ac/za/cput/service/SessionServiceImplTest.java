package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SessionRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Session;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.SessionFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SessionServiceImplTest {

    private SessionRepositoryImpl repository;
    private Session session;

    private Session getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SessionRepositoryImpl.getRepository();
        this.session = SessionFactory.getSession("","");
    }

    @Test
    public void a_create() {
        Session created = this.repository.create(this.session);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.session);
    }

    @Test
    public void c_update() {
        String newSessionType = "Session 2";
        Session updated = new Session.Builder().copy(getSaved()).sessionType(newSessionType).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newSessionType, updated.getsessionType());
    }

    @Test
    public void e_delete() {
        Session saved = getSaved();
        this.repository.delete(saved.getsessionType());
        d_getAll();
    }

    @Test
    public void b_read() {
        Session saved = getSaved();
        Session read = this.repository.read(saved.getsessionType());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Session> sessions = this.repository.getAll();
        System.out.println("In getall, all = " + sessions);
    }
}