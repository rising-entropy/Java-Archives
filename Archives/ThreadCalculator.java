import java.util.*;

class Addition extends Thread{

    int a, b;
    Addition(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void run()
    {
        int c=a;
        for(int i=0; i<b; i++)
        {
            c+=1;
        }
        System.out.println("Addition is: "+String.valueOf(c));
    }
}

class Subtraction extends Thread{

    int a, b;
    Subtraction(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void run()
    {
        int c=a;
        for(int i=0; i<b; i++)
        {
            c-=1;
        }
        System.out.println("Subtraction is: "+String.valueOf(c));
    }
}

class Multiplication extends Thread{

    int a, b;
    Multiplication(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void run()
    {
        int c=0;
        for(int i=0; i<b; i++)
        {
            c+=a;
        }
        System.out.println("Multiplication is: "+String.valueOf(c));
    }
}

class Division extends Thread{

    int a, b;
    Division(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void run()
    {
        System.out.println("Division is: "+String.valueOf(a/b));
    }
}

class Modulus extends Thread{

    int a, b;
    Modulus(int a, int b)
    {
        this.a = a;
        this.b = b;
    }

    public void run()
    {
        System.out.println("Modulus is: "+String.valueOf(a%b));
    }
}

public class ThreadCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.println("Enter 2 Numbers:");
        a = sc.nextInt();
        b = sc.nextInt();

        Thread add = new Thread(new Addition(a, b));
        Thread sub = new Thread(new Subtraction(a, b));
        Thread mul = new Thread(new Multiplication(a, b));
        Thread div = new Thread(new Division(a, b));
        Thread mod = new Thread(new Modulus(a, b));

        add.start();
        sub.start();
        mul.start();
        div.start();
        mod.start();
    }
}
