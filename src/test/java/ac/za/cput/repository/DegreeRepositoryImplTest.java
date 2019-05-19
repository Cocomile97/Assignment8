package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DegreeRepository;
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
public class DegreeRepositoryImplTest {

    private DegreeRepository repository;
    private Degree degree;

    private Degree getSavedDegree() {
        Set<Degree> savedDegrees = this.repository.getAll();
        return savedDegrees.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DegreeRepositoryImpl.getRepository();
        this.degree =  DegreeFactory.getDegree("","");
    }

    @Test
    public void a_create() {
        Degree created = this.repository.create(this.degree);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.degree);
    }

    @Test
    public void b_read() {
        Degree savedDegree = getSavedDegree();
        System.out.println("In read, courseId = "+ savedDegree.getDegreeName());
        Degree read = this.repository.read(savedDegree.getDegreeName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedDegree, read);
    }

    @Test
    public void e_delete() {
        Degree savedDegree = getSavedDegree();
        this.repository.delete(savedDegree.getDegreeName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Degree degree = new Degree.Builder().copy(getSavedDegree()).degreeName(newname).build();
        System.out.println("In update, about_to_updated = " + degree);
        Degree updated = this.repository.update(degree);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDegreeName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Degree> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
