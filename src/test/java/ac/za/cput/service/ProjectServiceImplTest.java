package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.ProjectRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Project;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.ProjectFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectServiceImplTest {

    private ProjectRepositoryImpl repository;
    private Project project;

    private Project getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectRepositoryImpl.getRepository();
        this.project = ProjectFactory.getProject("","","");
    }

    @Test
    public void a_create() {
        Project created = this.repository.create(this.project);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.project);
    }

    @Test
    public void c_update() {
        String newProjectName = "Project 3";
        Project updated = new Project.Builder().copy(getSaved()).projectName(newProjectName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newProjectName, updated.getProjectName());
    }

    @Test
    public void e_delete() {
        Project saved = getSaved();
        this.repository.delete(saved.getProjectName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Project saved = getSaved();
        Project read = this.repository.read(saved.getProjectName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Project> projects = this.repository.getAll();
        System.out.println("In getall, all = " + projects);
    }
}