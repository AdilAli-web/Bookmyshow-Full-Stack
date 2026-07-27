package ExecutorServiceExample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class EmailTask implements Runnable
{
    String studentEmail;
    EmailTask(String studentEmail)
    {
        this.studentEmail=studentEmail;
    }

    @Override
    public void run() {
        System.out.println("Sending email to "+studentEmail +" by"
        +Thread.currentThread().getName());
    }
}


public class Test2 {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(2);

        String[] email={
                "rahul@gamil.com",
                "divya@gamil.com",
                "rohit@gamil.com",
                "chetan@gamil.com",
                "yuvi@gamil.com",
                "ashu@gamil.com"
        };

        for(String e:email)
        {
            executorService.execute(new EmailTask(e));
            executorService.submit(new EmailTask(e));
        }

        executorService.shutdown();
    }
}
