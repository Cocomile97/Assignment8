package ac.za.cput.domain;



public class Account {

    private String accountType, accountName;

    private Account() {
    }

    private Account(Builder builder) {
        this.accountType = builder.accountType;
        this.accountName = builder.accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountName() {
        return accountName;
    }

    public static class Builder{

        private String accountType, accountName;

        public Builder accountType(String accountType) {
            this.accountType = accountType;
            return this;
        }

        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }
        public Account.Builder copy (Account account){
            this.accountName = account.accountName;
            this.accountType = account.accountType;

            return this;
        }
        public Account build() {
            return new Account(this);
        }
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountType='" + accountType + '\'' +
                ", accountName='" + accountName + '\'' +
                '}';
    }
}