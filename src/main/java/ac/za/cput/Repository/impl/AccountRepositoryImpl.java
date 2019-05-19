package ac.za.cput.Repository.impl;

import ac.za.cput.Repository.AccountRepository;
import ac.za.cput.domain.Account;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountRepositoryImpl implements AccountRepository {

    private static AccountRepositoryImpl repository = null;
    private Set<Account> accounts;

    private AccountRepositoryImpl(){
        this.accounts = new HashSet();
    }

    private Account findAccount(String accountType) {
        return this.accounts.stream()
                .filter(account -> account.getAccountType().trim().equals(accountType))
                .findAny()
                .orElse(null);
    }

    public static AccountRepositoryImpl getRepository(){
        if (repository == null) repository = new AccountRepositoryImpl();
        return repository;
    }


    public Account create(Account account){
        this.accounts.add(account);
        return account;
    }

    public Account read(final String accountType){
        Account account = findAccount(accountType);
        return account;
    }

    public void delete(String accountType) {
        Account account = findAccount(accountType);
        if (account != null) this.accounts.remove(account);
    }

    public Account update(Account account){
        Account toDelete = findAccount(account.getAccountType());
        if(toDelete != null) {
            this.accounts.remove(toDelete);
            return create(account);
        }
        return null;
    }


    public Set<Account> getAll(){
        return this.accounts;
    }
}
