package example_exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestExceptions {

    public static void main(String[] args) {
        try {
            handleFile();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        checkMaths();
    }

    private static void checkMaths() throws ArithmeticException {
    }

    private static void handleFile() throws FileNotFoundException {
        File file = new File("abc");
        FileInputStream fis = new FileInputStream(file);
        // throw -> is used to throw an exception from the place to the calling method
        throw new ArithmeticException();

        // try, catch, finally, throw, throws

    }
}
