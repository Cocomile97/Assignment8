package ac.za.cput.repository;

import ac.za.cput.Repository.AssistantRepository;
import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.impl.AssistantRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;
import ac.za.cput.factory.AssistantFactory;
import ac.za.cput.factory.CourseFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssistantRepositoryImplTest {

    private AssistantRepository repository;
    private Assistant assistant;

    private Assistant getSavedAssistant() {
        Set<Assistant> savedAssistants = this.repository.getAll();
        return savedAssistants.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssistantRepositoryImpl.getRepository();
        this.assistant =  AssistantFactory.getAssistant("","", 99);
    }

    @Test
    public void a_create() {
        Assistant created = this.repository.create(this.assistant);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.assistant);
    }

    @Test
    public void b_read() {
        Assistant savedAssistant = getSavedAssistant();
        System.out.println("In read, courseId = "+ savedAssistant.getAssistanttId());
        Assistant read = this.repository.read(savedAssistant.getAssistanttId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedAssistant, read);
    }

    @Test
    public void e_delete() {
        Assistant savedAssistant = getSavedAssistant();
        this.repository.delete(savedAssistant.getAssistanttId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Assistant Name";
        Assistant assistant = new Assistant.Builder().copy(getSavedAssistant()).assistantFirstName(newname).build();
        System.out.println("In update, about_to_updated = " + assistant);
        Assistant updated = this.repository.update(assistant);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getAssistantFirstName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Assistant> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
