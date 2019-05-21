package ac.za.cput.service;

import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.StreamRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Stream;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.StreamFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StreamServiceImplTest {

    private StreamRepositoryImpl repository;
    private Stream stream;

    private Stream getSaved(){
        return this.repository.getAll().iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StreamRepositoryImpl.getRepository();
        this.stream = StreamFactory.getStream("","");
    }

    @Test
    public void a_create() {
        Stream created = this.repository.create(this.stream);
        System.out.println("In create, created = " + created);
        Assert.assertNotNull(created);
        Assert.assertSame(created, this.stream);
    }

    @Test
    public void c_update() {
        String newStreamName = "Comnet";
        Stream updated = new Stream.Builder().copy(getSaved()).streamName(newStreamName).build();
        System.out.println("In update, updated = " + updated);
        this.repository.update(updated);
        Assert.assertSame(newStreamName, updated.getStreamName());
    }

    @Test
    public void e_delete() {
        Stream saved = getSaved();
        this.repository.delete(saved.getStreamName());
        d_getAll();
    }

    @Test
    public void b_read() {
        Stream saved = getSaved();
        Stream read = this.repository.read(saved.getStreamName());
        System.out.println("In read, read = "+ read);
        Assert.assertSame(read, saved);
    }

    @Test
    public void d_getAll() {
        Set<Stream> streams = this.repository.getAll();
        System.out.println("In getall, all = " + streams);
    }
}