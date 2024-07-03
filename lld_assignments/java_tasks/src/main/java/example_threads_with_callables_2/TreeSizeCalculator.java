package example_threads_with_callables_2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService executorService;

    public TreeSizeCalculator(Node root, ExecutorService executorService) {
        //System.out.println("from treesizeconstructor");
        this.root = root;
        this.executorService = executorService;
    }

    @Override
    public Integer call() throws Exception {
        if (root == null) {
            return 0;
        }
        TreeSizeCalculator leftSizeCalculator = new TreeSizeCalculator(root.left, executorService);
        Future<Integer> leftSizeFuture = executorService.submit(leftSizeCalculator);

        TreeSizeCalculator rightSizeCalculator = new TreeSizeCalculator(root.right, executorService);
        Future<Integer> rightSizeFuture = executorService.submit(rightSizeCalculator);

        return leftSizeFuture.get() + rightSizeFuture.get() + 1;
    }
}