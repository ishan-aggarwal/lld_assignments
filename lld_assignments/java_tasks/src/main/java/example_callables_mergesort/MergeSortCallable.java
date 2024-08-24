package example_callables_mergesort;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSortCallable implements Callable<List<Integer>> {
    private List<Integer> list;
    private ExecutorService executorService;

    MergeSortCallable(List<Integer> list, ExecutorService executorService) {
        this.list = list;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {

        if (list.size() <= 1) {
            return list;
        }

        //recursive case
        int n = list.size();
        int mid = n / 2;

        List<Integer> leftArr = new ArrayList<>(list.subList(0, mid));
        List<Integer> rightArr = new ArrayList<>(list.subList(mid, n));

        //create MergeSortCallable objects for both the two sub-lists recursively
        MergeSortCallable leftMergeSortCallable = new MergeSortCallable(leftArr, executorService);
        MergeSortCallable rightMergeSortCallable = new MergeSortCallable(rightArr, executorService);

        Future<List<Integer>> leftFuture = executorService.submit(leftMergeSortCallable);
        Future<List<Integer>> rightFuture = executorService.submit(rightMergeSortCallable);

        leftArr = leftFuture.get();
        rightArr = rightFuture.get();

        // Merge the sorted sub-lists
        List<Integer> output = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < leftArr.size() && j < rightArr.size()) {
            if (leftArr.get(i) < rightArr.get(j)) {
                output.add(leftArr.get(i));
                i++;
            } else {
                output.add(rightArr.get(j));
                j++;
            }
        }
        // copy the remaining elements
        while (i < leftArr.size()) {
            output.add(leftArr.get(i));
            i++;
        }
        while (j < rightArr.size()) {
            output.add(rightArr.get(j));
            j++;
        }
        return output;
    }
}