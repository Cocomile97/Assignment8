package ac.za.cput.Repository;

import ac.za.cput.domain.Review;

import java.util.HashSet;
import java.util.Set;

public interface ReviewRepository extends  IRepository<Review, String> {

    Set<Review> getAll();
}
