
class MyThread4 extends Thread
{
    @Override
    public void run() {
        for(int i=1;i<=5;i++)
        {
            System.out.println("Thread running : "+i);
            try {
                Thread.sleep(3000);
                System.out.println("Sleep for 3 sec");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class SleepDemo {
    public static void main(String[] args) {
        MyThread4 t1= new MyThread4();
        t1.start();

        System.out.println("Main Thread...");
    }
}
