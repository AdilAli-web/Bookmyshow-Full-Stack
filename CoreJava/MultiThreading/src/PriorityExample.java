
class MyRunnable implements Runnable
{
    @Override
    public void run() {
         Thread thread=Thread.currentThread();
        System.out.println("Thread : "+thread.getName()+" Priority "+thread.getPriority());
    }
}

public class PriorityExample {
    public static void main(String[] args) {
        Thread thread=Thread.currentThread();
        System.out.println("Thread : "+thread.getName()+" Priority "+thread.getPriority());
        Thread t1=new Thread(new MyRunnable(),"Thread-1");
        Thread t2=new Thread(new MyRunnable(),"Thread-2");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();

        System.out.println("Main thread");
    }
}
