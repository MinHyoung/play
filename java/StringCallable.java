import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class StringCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(10000);
        return Thread.currentThread().getName();
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        List<Future<String>> results = new ArrayList<>();
        Callable<String> callable = new StringCallable();

        for (int i = 0; i < 100; i++) {
            results.add(executor.submit(callable));
        }
        for (Future<String> result : results) {
            try {
                System.out.println(new Date() + "::" + result.get());
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
