package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LectureRepository;
import ac.za.cput.Repository.OfficeRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.LectureRepositoryImpl;
import ac.za.cput.Repository.impl.OfficeRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Lecture;
import ac.za.cput.domain.Office;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.LectureFactory;
import ac.za.cput.factory.OfficeFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficeRepositoryImplTest {

    private OfficeRepository repository;
    private Office office;

    private Office getSavedOffice() {
        Set<Office> savedOfficies = this.repository.getAll();
        return savedOfficies.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = OfficeRepositoryImpl.getRepository();
        this.office =  OfficeFactory.getOffice("","");
    }

    @Test
    public void a_create() {
        Office created = this.repository.create(this.office);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.office);
    }

    @Test
    public void b_read() {
        Office savedOffice = getSavedOffice();
        System.out.println("In read, courseId = "+ savedOffice.getOfficeId());
        Office read = this.repository.read(savedOffice.getOfficeId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedOffice, read);
    }

    @Test
    public void e_delete() {
        Office savedOffice = getSavedOffice();
        this.repository.delete(savedOffice.getOfficeId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Office office = new Office.Builder().copy(getSavedOffice()).officeId(newname).build();
        System.out.println("In update, about_to_updated = " + office);
        Office updated = this.repository.update(office);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getOfficeId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Office> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
