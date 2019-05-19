package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.DeptRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.DeptRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Dept;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.DeptFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeptRepositoryImplTest {

    private DeptRepository repository;
    private Dept dept;

    private Dept getSavedDept() {
        Set<Dept> savedDepts = this.repository.getAll();
        return savedDepts.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DeptRepositoryImpl.getRepository();
        this.dept =  DeptFactory.getDept("Test Course","");
    }

    @Test
    public void a_create() {
        Dept created = this.repository.create(this.dept);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.dept);
    }

    @Test
    public void b_read() {
        Dept savedDept = getSavedDept();
        System.out.println("In read, courseId = "+ savedDept.getDeptId());
        Dept read = this.repository.read(savedDept.getDeptId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedDept, read);
    }

    @Test
    public void e_delete() {
        Dept savedDept = getSavedDept();
        this.repository.delete(savedDept.getDeptId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Dept dept = new Dept.Builder().copy(getSavedDept()).deptId(newname).build();
        System.out.println("In update, about_to_updated = " + dept);
        Dept updated = this.repository.update(dept);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getDeptId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Dept> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
