package example_callables_mergesort;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list = List.of(5, 2, 7, 35, 1, 12, 21, 17);
        ExecutorService executorService = Executors.newCachedThreadPool();

        MergeSortCallable sorter = new MergeSortCallable(list, executorService);
        Future<List<Integer>> output = executorService.submit(sorter);

        System.out.println(output.get());

        executorService.shutdownNow();
    }
}
