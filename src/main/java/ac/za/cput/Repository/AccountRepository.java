package ac.za.cput.Repository;

import ac.za.cput.domain.Account;
import ac.za.cput.domain.Course;

import java.util.HashSet;
import java.util.Set;

public interface AccountRepository extends  IRepository<Account, String> {
    Set<Account> getAll();
}
