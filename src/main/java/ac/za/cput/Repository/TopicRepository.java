package ac.za.cput.Repository;

import ac.za.cput.domain.Calendar;
import ac.za.cput.domain.Topic;

import java.util.HashSet;
import java.util.Set;

public interface TopicRepository extends  IRepository<Topic, String> {
    Set<Topic> getAll();
}
