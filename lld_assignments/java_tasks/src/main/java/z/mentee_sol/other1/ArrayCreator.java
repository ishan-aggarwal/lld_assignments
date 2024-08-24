package z.mentee_sol.other1;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.List;

public class ArrayCreator implements Callable<ArrayList<Integer>> {
    int n;

    ArrayCreator(int n) {
        this.n = n;
    }

    public ArrayList<Integer> call() {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        return ans;
    }
}