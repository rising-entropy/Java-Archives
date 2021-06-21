import java.util.*;
import java.io.*;

public class BankDesk {

    static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    static void makeChoice(BankAccount ba)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\nChoose Your Action:");
        System.out.println("1. Deposit Amount.");
        System.out.println("2. Withdraw Amount.");
        System.out.println("3. Get Account Details.");
        System.out.println("4. Exit.");

        System.out.print("\nYour Choice: ");
        int choice = sc.nextInt();

        if(choice==1)
        {
            System.out.println("\nEnter Amount to Deposit: ");
            long amt = sc.nextLong();
            Boolean resp = ba.depositAmount(amt);
            if(resp == true)
            {
                System.out.println("Amount Deposited Successfully.");
                System.out.println("Your current Account Balance is: "+String.valueOf(ba.balance));
            }
            makeChoice(ba);
        }
        else if(choice==2)
        {
            System.out.println("\nYour current Account Balance is: "+String.valueOf(ba.balance));
            System.out.println("\nEnter Amount to Withdraw: ");
            long amt = sc.nextLong();
            Boolean resp = ba.withdrawAmount(amt);
            if(resp == true)
            {
                System.out.println("Amount Withdrawn Successfully.");
                System.out.println("Your current Account Balance is: "+String.valueOf(ba.balance));
            }
            else
            {
                System.out.println("Insufficient Balance. Try Again");
            }
            makeChoice(ba);
        }
        else if(choice==3)
        {
            ba.accountDetails();
            makeChoice(ba);
        }
        else if(choice==4)
        {
            System.out.println("\nThank Your Using our Service.");
            System.exit(1);
        }
        else
        {
            System.out.println("Inalid Choice. Try Again.");
            makeChoice(ba);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("-- Bank Account --\n");
        System.out.print("Enter your Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Account Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        long bal = sc.nextLong();

        //randomly set an account number
        int acntNum = getRandomNumber(200, 1200);

        //object of the bank-account
        BankAccount ba = new BankAccount(name, type, acntNum, bal);

        makeChoice(ba);
    }
}
