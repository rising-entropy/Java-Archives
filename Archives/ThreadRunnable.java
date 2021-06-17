class NestThoseThreads implements Runnable{
    public void run()
    {
        try{
            System.out.println("I am in Nested Thread.");
            Thread.sleep(2000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

class ThoseThreads implements Runnable{
    public void run()
    {
        System.out.println("I am in Parent Thread.");
        //nested thread
        Thread nested = new Thread(new NestThoseThreads(), "DevangJr");
        nested.start();
        System.out.println("Nested thread Name: "+String.valueOf(nested.getName()));
        System.out.println("Nested thread ID: "+String.valueOf(nested.getId()));
        System.out.println("Nested thread Priority: "+String.valueOf(nested.getPriority()));
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            System.out.println(e);
        }
    }
}

public class ThreadRunnable {
    public static void main(String[] args) {
        //custom name in constructor
        Thread thatThread = new Thread(new ThoseThreads(), "Devang");
        thatThread.run();
        thatThread.setPriority(3);
        
        System.out.println("Thread Name: "+String.valueOf(thatThread.getName()));
        System.out.println("Thread ID: "+String.valueOf(thatThread.getId()));
        System.out.println("Thread Priority: "+String.valueOf(thatThread.getPriority()));
    }
}
