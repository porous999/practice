package Extra;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TryExecutorService {


    public static void main(String[] args) {

        ExecutorService thisExecutorService = Executors.newSingleThreadExecutor();
        thisExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                printSomething();
                System.out.println("Done running!!");
            }

        });
        thisExecutorService.shutdown();

        System.out.println("In main!!");
    }

    static void printSomething() {
        for (int i = 0; i < 3; i++) {
            System.out.println("In executor!!");
            try {
                TimeUnit.SECONDS.sleep(3L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
