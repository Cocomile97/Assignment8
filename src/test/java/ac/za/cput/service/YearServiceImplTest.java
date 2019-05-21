package ac.za.cput.service;

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
public class YearServiceImplTest {

    private YearRepositoryImpl repository;
    private Year year;

    private Year getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = YearRepositoryImpl.getRepository();
        this.year = YearFactory.getYear("");
    }

    @Test
    public void a_create() {
        Year created = this.repository.create(this.year);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.year);
    }

    @Test
    public void c_update() {
        String newYearNum = "Year 3";
        Year updated = new Year.Builder().copy(getSaved()).yearNum(newYearNum).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newYearNum, updated.getyearNum());
    }

    @Test
    public void e_delete() {
        Year saved = getSaved();
        this.repository.delete(saved.getyearNum());
        d_getAll();
    }

    @Test
    public void b_read() {
        Year saved = getSaved();
        Year read = this.repository.read(saved.getyearNum());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Year> years = this.repository.getAll();
        System.out.println("In getall, all = " + year);
    }
}