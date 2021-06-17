public class Account {

    int accountNumber, balance;
    String name;
    
    Account(int accNum, int bal, String name)
    {
        this.accountNumber = accNum;
        this.balance = bal;
        this.name = name;
    }

    Boolean debitBalance(int amt)
    {
        if(amt<=this.balance)
        {
            this.balance -= amt;
            return true;
        }
        return false;
    }

    Boolean creditBalance(int amt)
    {
        this.balance += amt;
        return true;
    }

    int getBalance()
    {
        return this.balance;
    }
}
