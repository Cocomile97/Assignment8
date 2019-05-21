package ac.za.cput.service.impl;

import ac.za.cput.Repository.AccountRepository;
import ac.za.cput.Repository.impl.AccountRepositoryImpl;
import ac.za.cput.domain.Account;
import ac.za.cput.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AccountServiceImpl implements AccountService {

    private static AccountServiceImpl service = null;
    private AccountRepository repository;

    private AccountServiceImpl() {
        this.repository = AccountRepositoryImpl.getRepository();
    }

    public static AccountServiceImpl getService(){
        if (service == null) service = new AccountServiceImpl();
        return service;
    }

    @Override
    public Account create(Account account) {
        return this.repository.create(account);
    }

    @Override
    public Account update(Account account) {
        return this.repository.update(account);
    }

    @Override
    public void delete(String s) {
        this.repository.delete(s);
    }

    @Override
    public Account read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Set<Account> getAll() {
        return this.repository.getAll();
    }
}