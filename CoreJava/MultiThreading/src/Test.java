

class MyThread3 extends Thread
{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " child");
        System.out.println("Running....");
    }
}
public class Test {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"main ");

        MyThread3 t1= new MyThread3();
        t1.setName("Child-thread");
        t1.start();


    }
}
