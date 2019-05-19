package ac.za.cput.repository;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.SessionRepository;
import ac.za.cput.Repository.StreamRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.SessionRepositoryImpl;
import ac.za.cput.Repository.impl.StreamRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Session;
import ac.za.cput.domain.Stream;
import ac.za.cput.factory.CourseFactory;
import ac.za.cput.factory.SessionFactory;
import ac.za.cput.factory.StreamFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StreamRepositoryImplTest {

    private StreamRepository repository;
    private Stream stream;

    private Stream getSavedStream() {
        Set<Stream> savedStreams = this.repository.getAll();
        return savedStreams.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = StreamRepositoryImpl.getRepository();
        this.stream =  StreamFactory.getStream("Test Course","");
    }

    @Test
    public void a_create() {
        Stream created = this.repository.create(this.stream);
        System.out.println("In create, created = " + created);
        d_getAll();
        Assert.assertSame(created, this.stream);
    }

    @Test
    public void b_read() {
        Stream savedStream = getSavedStream();
        System.out.println("In read, courseId = "+ savedStream.getStreamId());
        Stream read = this.repository.read(savedStream.getStreamId());
        System.out.println("In read, read = " + read);
        d_getAll();
        Assert.assertEquals(savedStream, read);
    }

    @Test
    public void e_delete() {
        Stream savedStream = getSavedStream();
        this.repository.delete(savedStream.getStreamId());
        d_getAll();
    }

    @Test
    public void c_update() {
        String newname = "New Test Course Name";
        Stream stream = new Stream.Builder().copy(getSavedStream()).streamId(newname).build();
        System.out.println("In update, about_to_updated = " + stream);
        Stream updated = this.repository.update(stream);
        System.out.println("In update, updated = " + updated);
        Assert.assertSame(newname, updated.getStreamId());
        d_getAll();
    }

    @Test
    public void d_getAll() {
        Set<Stream> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
