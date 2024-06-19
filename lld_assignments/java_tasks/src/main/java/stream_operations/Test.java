package stream_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", " ", "Stream", " ", "API");

// Concatenating strings
        String result = words.stream()
                .collect(Collectors.joining(", "));

        System.out.println("Concatenated String: " + result); // Output: Concatenated String: Hello

    }
}
