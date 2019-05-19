package ac.za.cput.Repository.impl;


import ac.za.cput.Repository.StreamRepository;
import ac.za.cput.domain.Stream;

import java.util.HashSet;
import java.util.Set;

public class StreamRepositoryImpl implements StreamRepository {

    private static StreamRepository repository = null;
    private Set<Stream> streams;

    private StreamRepositoryImpl(){

        this.streams = new HashSet<Stream>();
    }

    public static StreamRepository getRepository(){
        if (repository == null) repository = new StreamRepositoryImpl();
        return repository;
    }

    public Stream create(Stream stream) {
        //insert into the set of departments
        return stream;
    }

    public Stream read(String StreamId){
        // find the department with the id and return it

        return null;
    }

    public Stream update(Stream stream){
        // find the department that matches this and update it
        return null;
    }

    public void delete(String StreamId) {
        // find the department with id and delete it
    }

    public Set<Stream> getAll(){



        return this.streams;
    }
}