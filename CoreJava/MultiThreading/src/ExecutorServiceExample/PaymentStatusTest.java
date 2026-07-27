package ExecutorServiceExample;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.SocketHandler;

class PaymentStatus implements Callable<String>
{
    int orderId;

    PaymentStatus(int orderId)
    {
        this.orderId=orderId; //
    }

    public String call() throws Exception
    {
        Thread.sleep(5000);
        return "Payment SUCCESS for order " +orderId;
    }
}

public class PaymentStatusTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<String> future=executorService.submit(new PaymentStatus(101));
        System.out.println("Waiting for payment status....");
        String status=future.get();
        System.out.println(status);


        List<Callable<String>> tasks= Arrays.asList(
                ()->"total student : 500",
                ()->"total course : 123",
                ()->"total payment : 100"
        );

        List<Future<String >> res=executorService.invokeAll(tasks);

        for(Future<String> resu:res)
        {
            System.out.println(resu.get());
        }
        executorService.shutdown();





        executorService.shutdown();

    }
}
