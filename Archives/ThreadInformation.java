class Threads extends Thread{
    public void run()
    {
        for(int i=0; i<1; i++)
        {
            getThreadData();
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException ex){
                System.out.println(ex);
            }
        }
    }

    void getThreadData()
    {
        Thread t = Thread.currentThread();
        System.out.println("Thread ID: "+String.valueOf(t.getId()));
        System.out.println("Thread Name: "+String.valueOf(t.getName()));
        System.out.println("Thread Priority: "+String.valueOf(t.getPriority()));
        System.out.println();
    }
}

public class ThreadInformation {
    public static void main(String[] args) {
        Threads ts = new Threads();
        ts.start();        
    }
}
