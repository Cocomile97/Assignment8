package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.TopicRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.TopicRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Topic;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.TopicFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TopicRepositoryImplTest {

    private TopicRepository repository;
    private Topic topic;

    private Topic getSavedTopic() {
        Set<Topic> savedTopics = this.repository.getAll();
        return savedTopics.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = TopicRepositoryImpl.getRepository();
        this.topic =  TopicFactory.getTopic("Test Topic");
    }

    @Test
    public void a_create() {
        Topic created = this.repository.create(this.topic);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.topic);
    }

    @Test
    public void b_read() {
        Topic savedTopic = getSavedTopic();
        System.out.println("In read, courseId = "+ savedTopic.getTopicName());
        Topic read = this.repository.read(savedTopic.getTopicName());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedTopic, read);
    }

    @Test
    public void e_delete() {
        Topic savedTopic = getSavedTopic();
        this.repository.delete(savedTopic.getTopicName());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Topic Name";
        Topic topic = new Topic.Builder().copy(getSavedTopic()).topicName(newname).build();
        System.out.println("In update, about_to_updated = " + topic);
        Topic updated = this.repository.update(topic);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getTopicName());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Topic> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
