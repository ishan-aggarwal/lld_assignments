package example_exceptions;

public class MainClass2 {

    public static void main(String[] args) {
        System.out.println(check());
    }

    private static int check() {

        try {
            return 10;
        } catch (Exception e) {
            return 20;
        } finally {
            return 30;
        }

    }
}
