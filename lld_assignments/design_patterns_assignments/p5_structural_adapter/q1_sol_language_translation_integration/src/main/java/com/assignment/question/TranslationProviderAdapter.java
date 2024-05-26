package com.assignment.question;

import java.util.*;

public interface TranslationProviderAdapter {
    String convert(TranslationRequest request);

    List<String> getLanguages();
}