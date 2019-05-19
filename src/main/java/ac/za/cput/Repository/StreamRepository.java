package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Stream;

import java.util.HashSet;
import java.util.Set;

public interface StreamRepository extends  IRepository<Stream, String> {
    Set<Stream> getAll();
}
