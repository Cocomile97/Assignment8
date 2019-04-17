package ac.za.cput.factory;

import ac.za.cput.domain.Account;
import org.junit.Assert;
import org.junit.Test;

public class AccountFactoryTest {

    @Test
    public void getAccount() {

        String name = "";
        String type = "Premium";
        Account c = AccountFactory.getAccount(name,type);
        System.out.println(c);
        Assert.assertNotNull(c.getAccountName());
        Assert.assertNotNull(c.getAccountName());
    }
}
