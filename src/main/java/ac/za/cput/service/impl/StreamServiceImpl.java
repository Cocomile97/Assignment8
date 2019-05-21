package ac.za.cput.service.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.StreamRepository;
import ac.za.cput.Repository.impl.CourseRepositoryImpl;
import ac.za.cput.Repository.impl.StreamRepositoryImpl;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Stream;
import ac.za.cput.service.CourseService;
import ac.za.cput.service.StreamService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StreamServiceImpl implements StreamService {

    private static StreamServiceImpl service = null;
    private StreamRepository repository;

    private StreamServiceImpl() {
        this.repository = StreamRepositoryImpl.getRepository();
    }

    public static StreamServiceImpl getService(){
        if (service == null) service = new StreamServiceImpl();
        return service;
    }

    @Override
    public Stream create(Stream stream) {
        return this.repository.create(stream);
    }

    @Override
    public Stream update(Stream stream) {
        return this.repository.update(stream);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Stream read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Stream> getAll() {
        return this.repository.getAll();
    }
}