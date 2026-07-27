package ExecutorServiceExample;

import java.util.concurrent.*;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Callable<Integer> task=()->{
            Thread.sleep(5000);
            return 10+20;
        };

        Future<Integer> future=executorService.submit(task);
        System.out.println(future.get());

        executorService.shutdown();
    }
}
