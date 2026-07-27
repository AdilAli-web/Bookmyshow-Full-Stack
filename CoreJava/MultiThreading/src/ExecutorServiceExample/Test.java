package ExecutorServiceExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



public class Test {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(3);


        for (int i = 1; i <=6; i++) {
            int taskNum=i;

            executor.submit(
                    ()->{
                        System.out.println("Task "+taskNum+" executed by" +Thread.currentThread().getName());
                    }

            );


        }
        executor.shutdown();
    }
}
