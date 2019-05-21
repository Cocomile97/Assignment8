package ac.za.cput.service;

import ac.za.cput.domain.Account;

import java.util.Set;

public interface AccountService extends IService<Account, String> {
    Set<Account> getAll();
}
