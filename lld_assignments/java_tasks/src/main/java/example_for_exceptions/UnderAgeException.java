package example_for_exceptions;

public class UnderAgeException extends Exception {
    public UnderAgeException() {
        super("You are under age exception");
    }

    public UnderAgeException(String msg) {
        super(msg);
    }
}

