package com.assignment.question;

import java.util.*;

// // The TranslationProviderAdapter interface defines operations that all concrete translation adapters must implement.
public interface TranslationProviderAdapter {
    String convert(TranslationRequest request);

    List<String> getLanguages();
}