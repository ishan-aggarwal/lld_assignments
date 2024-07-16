package example_point_and_rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

    public static boolean isSpecial(String text) {
        String tempText = alterText(text);
        return text.equals(tempText);
    }

    private static String alterText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.charAt(text.length() - 1) +
                alterText(text.substring(0, text.length() - 1));
    }


    static int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            result[2 * i] = a[i];
            result[(2 * i) + 1] = b[i];
        }
        return result;
    }

//    public int doThings(String numberString) {
//        try {
//            int i = Integer.parseInt(numberString);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return i;
//    }

    public static List<Integer> someFunction(final List<Integer> numbers) {
        List<Integer> res = new ArrayList<>();
        for (int i = numbers.size() - 1; i >= 0; i--) {
            res.add(numbers.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
        int result = 0;
        for (int number : numbers) {
            result *= number;
        }
        System.out.println(result);

        List<Integer> myNumbers = List.of(1, 2, 3, 4);
        System.out.println(someFunction(myNumbers));

        int[] a = {1, 2, 5};
        int[] b = {3, 4};
//        int[] res = merge(a, b);
//        System.out.println(Arrays.toString(res));


        System.out.println(isSpecial("ab1221ba"));
    }
}
