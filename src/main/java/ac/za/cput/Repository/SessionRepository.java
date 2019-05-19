package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Session;

import java.util.HashSet;
import java.util.Set;

public interface SessionRepository extends  IRepository<Session, String> {
    Set<Session> getAll();
}
