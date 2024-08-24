package example_threads_with_callables_2.other;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCalculator implements Callable<Integer> {
    private Node root;
    private ExecutorService ex;

    public TreeSizeCalculator(Node root, ExecutorService ex){
        this.root = root;
        this.ex = ex;
    }

    @Override
    public Integer call() throws Exception {
        if(root == null){
            return 0;
        }

        TreeSizeCalculator leftSizeCalculator = new TreeSizeCalculator(root.left, ex);
        Future<Integer> leftSizeFuture = ex.submit(leftSizeCalculator);

        TreeSizeCalculator rightSizeCalculator = new TreeSizeCalculator(root.right, ex);
        Future<Integer> rightSizeFuture = ex.submit(rightSizeCalculator);

        return leftSizeFuture.get() + rightSizeFuture.get() + 1;
    }
}