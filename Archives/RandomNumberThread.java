import java.util.*;

class ThreadTask extends Thread{
    public void run(){
        //random number lib
        Random r = new Random();
        for(int i=0; i<10; i++)
        {
            int thatInteger = r.nextInt(300);
            System.out.println("Random Number is: "+String.valueOf(thatInteger));
            if(thatInteger%2 == 0)
            {
                EvenThread et = new EvenThread(thatInteger);
                et.start();
            }
            else
            {
                OddThread ot = new OddThread(thatInteger); 
                ot.start();
            }
            //sleep for 1sec
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
    }
}

class EvenThread extends Thread{
    
    int num;

    EvenThread(int num)
    {
        this.num = num;
    }

    public void run()
    {
        System.out.println("Even Number, Square is: "+String.valueOf(num*num));
    }
}

class OddThread extends Thread{

    int num;

    OddThread(int num)
    {
        this.num = num;
    }

    public void run()
    {
        System.out.println("Odd Number, Cube is: "+String.valueOf(num*num*num));
    }
}

public class RandomNumberThread extends Thread{
    public static void main(String[] args) {
        ThreadTask tt = new ThreadTask();
        tt.start();
    }
}