public class JoinExample {
    public static void main(String[] args) throws InterruptedException {

        Payment p1= new Payment();
        Thread t1= new Thread(p1);
        t1.start();
        System.out.println("reading more info...from database");

        //---------------------------
        t1.join();  //this line executed by main thread so main thread will wait for t1
        System.out.println("Notification sent to User...");
    }
}

class Payment implements Runnable
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            System.out.println("Payment is done....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
