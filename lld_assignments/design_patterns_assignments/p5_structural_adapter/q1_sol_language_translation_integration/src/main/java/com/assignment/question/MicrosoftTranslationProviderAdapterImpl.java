package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

// The MicrosoftTranslationAdapter class is an adapter for the MicrosoftTranslateApi.

public class MicrosoftTranslationProviderAdapterImpl implements TranslationProviderAdapter {

    private MicrosoftTranslateApi microsoftTranslateApi = new MicrosoftTranslateApi();

    // The convert method calls the translate method of the MicrosoftTranslateApi.
    @Override
    public String convert(TranslationRequest request) {
        return microsoftTranslateApi.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    // The getLanguages method returns the list of languages supported by the MicrosoftTranslateApi.
    @Override
    public List<String> getLanguages() {
        return microsoftTranslateApi.getSupportedLanguages();
    }
}