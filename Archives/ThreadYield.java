class FirstThread extends Thread{
    public void run()
    {
        for(int i=0; i<100; i++)
        {
            if(i%50 == 0)
            {
                System.out.println("In 1st Thread");
            }
            Thread.yield();
            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}

class SecondThread extends Thread{
    public void run()
    {
        for(int i=0; i<300; i++)
        {
            Thread.yield();
            if(i%50 == 0)
            {
                System.out.println("In 2nd Thread");
            }
            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}

class ThirdThread extends Thread{
    public void run()
    {
        for(int i=0; i<500; i++)
        {
            Thread.yield();
            if(i%50 == 0)
            {
                System.out.println("In 3rd Thread");
            }
            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}

class FourthThread extends Thread{
    public void run()
    {
        for(int i=0; i<700; i++)
        {
            Thread.yield();
            if(i%50 == 0)
            {
                System.out.println("In 4th Thread");
            }
            try{
                Thread.sleep(2);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
}


public class ThreadYield {

    public static void main(String[] args) {
        Thread t1 = new Thread(new FirstThread(), "1");
        Thread t2 = new Thread(new SecondThread(), "2");
        Thread t3 = new Thread(new ThirdThread(), "3");
        Thread t4 = new Thread(new FourthThread(), "4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
