package LockDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter
{
    int count=0;
    Lock lock=new ReentrantLock();

    void increment()
    {
        lock.lock();
        try {

            count++;
        }
        finally {
            lock.unlock();
        }
    }
}

class CounterTest extends Thread
{
    Counter counter;

    CounterTest(Counter counter)
    {
        this.counter=counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <=1000; i++) {
            counter.increment();
        }
    }
}


public class Test {
    public static void main(String[] args) throws InterruptedException {

        Counter counter= new Counter();

        CounterTest t1=new CounterTest(counter);
        CounterTest t2=new CounterTest(counter);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.count);

    }
}
