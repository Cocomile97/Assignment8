package ac.za.cput.service;

import ac.za.cput.Repository.impl.AssistantRepositoryImpl;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.domain.Assistant;
import ac.za.cput.domain.Course;
import ac.za.cput.factory.AssistantFactory;
import ac.za.cput.factory.CourseFactory;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AssistantServiceImplTest {

    private AssistantRepositoryImpl repository;
    private Assistant assistant;

    private Assistant getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AssistantRepositoryImpl.getRepository();
        this.assistant = AssistantFactory.getAssistant("","",23);
    }

    @Test
    public void a_create() {
        Assistant created = this.repository.create(this.assistant);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.assistant);
    }

    @Test
    public void c_update() {
        String newAssistantName = "Adedire";
        Assistant updated = new Assistant.Builder().copy(getSaved()).assistantFirstName(newAssistantName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newAssistantName, updated.getAssistantFirstName());
    }

    @Test
    public void e_delete() {
        Assistant saved = getSaved();
        this.repository.delete(saved.getAssistanttId());
        d_getAll();
    }

    @Test
    public void b_read() {
        Assistant saved = getSaved();
        Assistant read = this.repository.read(saved.getAssistanttId());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Assistant> assistants = this.repository.getAll();
        System.out.println("In getall, all = " + assistants);
    }
}