package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.OfficeRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Office;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.OfficeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeServiceImplTest {

    private OfficeRepositoryImpl repository;
    private Office office;

    private Office getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = OfficeRepositoryImpl.getRepository();
        this.office = OfficeFactory.getOffice("","");
    }

    @Test
    public void a_create() {
        Office created = this.repository.create(this.office);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.office);
    }

    @Test
    public void c_update() {
        String newOfficeName = "Head Office";
        Office updated = new Office.Builder().copy(getSaved()).officeName(newOfficeName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newOfficeName, updated.getOfficeName());
    }

    @Test
    public void e_delete() {
        Office saved = getSaved();
        this.repository.delete(saved.getOfficeName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Office saved = getSaved();
        Office read = this.repository.read(saved.getOfficeName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Office> offices = this.repository.getAll();
        System.out.println("In getall, all = " + offices);
    }
}