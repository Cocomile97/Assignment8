package ac.za.cput.service;

import ac.za.cput.domain.Stream;

import java.util.Set;

public interface StreamService extends IService<Stream, String> {
    Set<Stream> getAll();
}