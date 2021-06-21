public class BankAccount {

    // data members
    String depositorName, accountType;
    long accountNumber, balance;

    //we can use the constructor to assign initial values
    BankAccount(String depositorName, String accountType, long accountNumber, long balance)
    {
        this.depositorName = depositorName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    Boolean depositAmount(long amount)
    {
        this.balance += amount;
        return true;
    }

    Boolean withdrawAmount(long amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    long currentBalance()
    {
        return this.balance;
    }

    void accountDetails()
    {
        System.out.println("\nYour Account Details:");
        System.out.println("Name of Depositor: "+this.depositorName);
        System.out.println("Account Type: "+this.accountType);
        System.out.println("Account Number: "+String.valueOf(this.accountNumber));
        System.out.println("Current Balance: "+String.valueOf(this.balance));
    }
}