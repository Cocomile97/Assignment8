package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.DegreeRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Degree;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.DegreeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DegreeServiceImplTest {

    private DegreeRepositoryImpl repository;
    private Degree degree;

    private Degree getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DegreeRepositoryImpl.getRepository();
        this.degree = DegreeFactory.getDegree("","");
    }

    @Test
    public void a_create() {
        Degree created = this.repository.create(this.degree);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.degree);
    }

    @Test
    public void c_update() {
        String newDegreeName = "Advanced Diploma";
        Degree updated = new Degree.Builder().copy(getSaved()).degreeName(newDegreeName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newDegreeName, updated.getDegreeName());
    }

    @Test
    public void e_delete() {
        Degree saved = getSaved();
        this.repository.delete(saved.getDegreeName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Degree saved = getSaved();
        Degree read = this.repository.read(saved.getDegreeName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Degree> degrees = this.repository.getAll();
        System.out.println("In getall, all = " + degrees);
    }
}