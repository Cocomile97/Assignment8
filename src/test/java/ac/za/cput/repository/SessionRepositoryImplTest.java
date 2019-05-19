package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SessionRepository;
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
public class SessionRepositoryImplTest {

    private SessionRepository repository;
    private Session session;

    private Session getSavedSession() {
        Set<Session> savedSession = this.repository.getAll();
        return savedSession.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = SessionRepositoryImpl.getRepository();
        this.session =  SessionFactory.getSession("Test Course","");
    }

    @Test
    public void a_create() {
        Session created = this.repository.create(this.session);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.session);
    }

    @Test
    public void b_read() {
        Session savedSession = getSavedSession();
        System.out.println("In read, courseId = "+ savedSession.getsessionType());
        Session read = this.repository.read(savedSession.getsessionType());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedSession, read);
    }

    @Test
    public void e_delete() {
        Session savedSession = getSavedSession();
        this.repository.delete(savedSession.getsessionType());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Session session = new Session.Builder().copy(getSavedSession()).sessionType(newname).build();
        System.out.println("In update, about_to_updated = " + session);
        Session updated = this.repository.update(session);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getsessionType());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Session> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
