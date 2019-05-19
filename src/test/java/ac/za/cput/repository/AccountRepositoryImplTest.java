package ac.za.cput.repository;

import ac.za.cput.Repository.AccountRepository;
import ac.za.cput.Repository.impl.AccountRepositoryImpl;
import ac.za.cput.domain.Account;
import ac.za.cput.domain.Assignment;
import ac.za.cput.domain.Course;
import ac.za.cput.factory.AccountFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AccountRepositoryImplTest {

    private AccountRepository repository;
    private Account account;

    private Account getSavedAccount() {
        Set<Account> savedAccount = this.repository.getAll();
        return savedAccount.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.repository = AccountRepositoryImpl.getRepository();
        this.account =  AccountFactory.getAccount("","");
    }

    @Test
    public void a_create() {
        Account created = this.repository.create(this.account);
        System.out.println("In create, created = " + created);
        d_getAll();
        assertSame(created, this.account);
    }

    @Test
    public void b_read() {
        Account savedAccount = getSavedAccount();
        System.out.println("In read, accountName = "+ savedAccount.getAccountType());
        Account read = this.repository.read(savedAccount.getAccountType());
        System.out.println("In read, read = " + read);
        d_getAll();
        assertEquals(savedAccount, read);
    }

    @Test
    public void e_delete() {
        Account savedAccount = getSavedAccount();
        this.repository.delete(savedAccount.getAccountType());
        d_getAll();
    }

    @Test
        public void c_update() {
            String newname = "New Test Course Name";
            Account account = new Account.Builder().copy(getSavedAccount()).accountType(newname).build();
            System.out.println("In update, about_to_updated = " + account);
            Account updated = this.repository.update(account);
            System.out.println("In update, updated = " + updated);
            Assert.assertSame(newname, updated.getAccountType());
            d_getAll();
        }
    @Test
    public void d_getAll() {
        Set<Account> all = this.repository.getAll();
        System.out.println("In getAll, all = " + all);
//        Assert.assertSame(1, all.size());
    }
}
