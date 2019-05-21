package ac.za.cput.service;

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
public class DeptServiceImplTest {

    private DeptRepositoryImpl repository;
    private Dept dept;

    private Dept getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = DeptRepositoryImpl.getRepository();
        this.dept = DeptFactory.getDept("","");
    }

    @Test
    public void a_create() {
        Dept created = this.repository.create(this.dept);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.dept);
    }

    @Test
    public void c_update() {
        String newDeptName = "Nursing";
       Dept  updated = new Dept.Builder().copy(getSaved()).deptName(newDeptName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newDeptName, updated.getDeptName());
    }

    @Test
    public void e_delete() {
        Dept saved = getSaved();
        this.repository.delete(saved.getDeptName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Dept saved = getSaved();
        Dept read = this.repository.read(saved.getDeptName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Dept> depts = this.repository.getAll();
        System.out.println("In getall, all = " + depts);
    }
}