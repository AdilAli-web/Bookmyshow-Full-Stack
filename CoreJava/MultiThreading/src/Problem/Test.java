package Problem;

class Counter
{
    int count=0;

    void increment()
    {
        System.out.println("incrementing count......");
        synchronized (this)
        {
            count++;
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
