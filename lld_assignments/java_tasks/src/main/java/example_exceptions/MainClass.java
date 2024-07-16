package example_exceptions;

public class MainClass {

    public static void main(String[] args) {
        try {
            main(args);
        } catch (NumberFormatException | NullPointerException e) {
            System.out.println("inside");
        } catch (Exception e) {
            System.out.println(2);
        }
    }
}
