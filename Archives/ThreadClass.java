public class ThreadClass extends Thread {

    public void run()
    {
        long c=0;
        for(int i=1; i<=50000; i++)
        {
            c += 1;
        }
        System.out.println("Sum 1-50000 is: "+String.valueOf(c));
        
        //make a thread sleep (1 sec)
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException ex){
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
        //getting default name, id, priority
        ThreadClass tc = new ThreadClass();
        tc.start();
        System.out.println("Current Thread State: "+String.valueOf(tc.getState()));
        System.out.println("Thread ID: "+String.valueOf(tc.getId()));
        System.out.println("Thread Name: "+String.valueOf(tc.getName()));
        System.out.println("Thread Priority: "+String.valueOf(tc.getPriority()));
        if(tc.isAlive())
        {
            System.out.println("Thread is alive.");
        }
        else
        {
            System.out.println("Thread is not alive. Has completed execution.");
        }
    }
}
