package ExecutorServiceExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultipleHit {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newFixedThreadPool(3);

        executorService.submit(()-> System.out.println("Order service"));
        executorService.submit(()-> System.out.println("payment service"));
        executorService.submit(()-> System.out.println("incovice service"));
    }
}
