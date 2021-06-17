import java.util.*;

class DebitBalance extends Thread{

    Account act;
    int amt;
    DebitBalance(Account a, int amt)
    {
        this.act = a;
        this.amt = amt;
    }

    public void run()
    {
        Boolean b =  this.act.debitBalance(this.amt);
        if(b == false)
        {
            System.out.println("Insufficient Balance.\n");
        }
    }

    Account getAccount()
    {
        return this.act;
    }
}

class CreditBalance extends Thread{

    Account act;
    int amt;
    CreditBalance(Account a, int amt)
    {
        this.act = a;
        this.amt = amt;
    }

    public void run()
    {
        Boolean b =  this.act.creditBalance(this.amt);
        if(b == false)
        {
            System.out.println("Insufficient Balance.\n");
        }
    }

    Account getAccount()
    {
        return this.act;
    }
}

public class BankDesk {

    static void makeChoice(Account a)
    {
        System.out.println("Choose your action:");
        System.out.println("1. Debit Balance");
        System.out.println("2. Credit Balance");
        System.out.println("3. View Balance\n");
        System.out.println("4. Exit\n");
        System.out.print("Your Choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        if(choice == 1)
        {
            int amt;
            System.out.print("Enter Amount to Debit: ");
            amt = sc.nextInt();
            DebitBalance db = new DebitBalance(a, amt);
            db.start();
            a = db.getAccount();
            System.out.println("Balance Debited Successfully.\n");
            makeChoice(a);
        }
        if(choice == 2)
        {
            int amt;
            System.out.print("Enter Amount to Credit: ");
            amt = sc.nextInt();
            CreditBalance db = new CreditBalance(a, amt);
            db.start();
            a = db.getAccount();
            System.out.println("Balance Credited Successfully.\n");
            makeChoice(a);
        }
        if(choice == 3)
        {
            System.out.println(a.name+", your Current Balance is: "+String.valueOf(a.balance)+"\n");
            makeChoice(a);
        }
        if(choice == 4)
        {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Account a = new Account(1, 2000, "Devang");
        makeChoice(a);
    }
}