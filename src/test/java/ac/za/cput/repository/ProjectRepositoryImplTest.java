package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.ProjectRepository;
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
public class ProjectRepositoryImplTest {

    private ProjectRepository repository;
    private Project project;

    private Project getSavedProject() {
        Set<Project> savedProjects = this.repository.getAll();
        return savedProjects.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = ProjectRepositoryImpl.getRepository();
        this.project =  ProjectFactory.getProject("","","");
    }

    @Test
    public void a_create() {
        Project created = this.repository.create(this.project);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.project);
    }

    @Test
    public void b_read() {
        Project savedProject = getSavedProject();
        System.out.println("In read, courseId = "+ savedProject.getProjectName());
        Project read = this.repository.read(savedProject.getProjectName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedProject, read);
    }

    @Test
    public void e_delete() {
        Project savedProject = getSavedProject();
        this.repository.delete(savedProject.getProjectName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Project project = new Project.Builder().copy(getSavedProject()).projectName(newname).build();
        System.out.println("In update, about_to_updated = " + project);
        Project updated = this.repository.update(project);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getProjectName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Project> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
