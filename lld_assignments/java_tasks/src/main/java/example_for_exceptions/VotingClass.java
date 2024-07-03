package example_for_exceptions;

public class VotingClass {
    public static void main(String[] args) {
        int i = 10;
        try {
            i = 20;
            System.out.println("Going to call the calledMethod"); // 1
            calledMethod();
            i = 30;
        } catch (UnderAgeException e) {
            i = 40;
            try {
                throw new RuntimeException(e);
            } catch (Exception ex) {

            }
        } finally {
            System.out.println("I am inside finally block"); // 3
        }
        System.out.println("Main has ended:: " + i);
    }

    public static void calledMethod() throws UnderAgeException {
        int age = 17;
        if (age < 18) {
            System.out.println("Handled age"); // 2
            throw new UnderAgeException();
        }
    }
}
