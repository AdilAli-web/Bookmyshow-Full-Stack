


class MyThread2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}

class MyThread extends Thread
{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}

public class ThreadTest{

    public static void main(String[] args) {

        //1. how to create thread : create class and make object
        MyThread t1= new MyThread(); //object
        t1.start(); //thread will create here

        MyThread2 t2= new MyThread2();
        Thread thread=new Thread(t2);
        thread.start();


        for (int i = 0; i < 5; i++) {

            System.out.println(Thread.currentThread().getName()+ " "+i);
        }
    }
}
