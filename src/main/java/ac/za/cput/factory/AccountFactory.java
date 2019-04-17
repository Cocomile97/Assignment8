package ac.za.cput.factory;

import ac.za.cput.domain.Account;
import ac.za.cput.util.Misc;

public class AccountFactory {


    public static Account getAccount(String accountName, String accountType) {

        return new Account.Builder().accountType(accountType)
                .accountName(accountName)
                .build();
    }
}