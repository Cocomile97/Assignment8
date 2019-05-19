package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.CourseRepository;
import ac.za.cput.Repository.LocationRepository;
import ac.za.cput.Repository.StreamRepository;
import ac.za.cput.domain.Course;
import ac.za.cput.domain.Location;
import ac.za.cput.domain.Stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamRepositoryImpl implements StreamRepository {

    private static StreamRepositoryImpl repository = null;
    private Set<Stream> streams;

    private StreamRepositoryImpl(){
        this.streams = new HashSet();
    }

    private Stream findStream(String streamId) {
        return this.streams.stream()
                .filter(stream -> stream.getStreamId().trim().equals(streamId))
                .findAny()
                .orElse(null);
    }

    public static StreamRepositoryImpl getRepository(){
        if (repository == null) repository = new StreamRepositoryImpl();
        return repository;
    }


    public Stream create(Stream stream){
        this.streams.add(stream);
        return stream;
    }

    public Stream read(final String streamId){
        Stream stream = findStream(streamId);
        return stream;
    }

    public void delete(String streamId) {
        Stream stream = findStream(streamId);
        if (stream != null) this.streams.remove(stream);
    }

    public Stream update(Stream stream){
        Stream toDelete = findStream(stream.getStreamId());
        if(toDelete != null) {
            this.streams.remove(toDelete);
            return create(stream);
        }
        return null;
    }


    public Set<Stream> getAll(){
        return this.streams;
    }
}
