package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.YearRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.YearRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Year;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.YearFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class YearRepositoryImplTest {

    private YearRepository repository;
    private Year year;

    private Year getSavedYear() {
        Set<Year> savedYears = this.repository.getAll();
        return savedYears.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = YearRepositoryImpl.getRepository();
        this.year =  YearFactory.getYear("Test Year");
    }

    @Test
    public void a_create() {
        Year created = this.repository.create(this.year);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.year);
    }

    @Test
    public void b_read() {
        Year savedYear= getSavedYear();
        System.out.println("In read, yearNum = "+ savedYear.getyearNum());
        Year read = this.repository.read(savedYear.getyearNum());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedYear, read);
    }

    @Test
    public void e_delete() {
        Year savedYear = getSavedYear();
        this.repository.delete(savedYear.getyearNum());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newYear = "New Test Year Num";
        Year year = new Year.Builder().copy(getSavedYear()).yearNum(newYear).build();
        System.out.println("In update, about_to_updated = " + year);
        Year updated = this.repository.update(year);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newYear, updated.getyearNum());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Year> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
