package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

// // The GoogleTranslationProviderAdapterImpl class is an adapter for the GoogleTranslateApi.
public class GoogleTranslationProviderAdapterImpl implements TranslationProviderAdapter {

    private GoogleTranslateApi googleTranslateApi = new GoogleTranslateApi();

    // The convert method converts the TranslationRequest to a GoogleTranslationRequest and calls the convert method of the GoogleTranslateApi.
    @Override
    public String convert(TranslationRequest request) {
        GoogleTranslationRequest googleTranslationRequest = new GoogleTranslationRequest(request.getText(),
                request.getSourceLanguage(),
                request.getTargetLanguage(),
                request.getConfidenceThreshold()
        );
        return googleTranslateApi.convert(googleTranslationRequest);
    }

    // The getLanguages method returns the list of languages supported by the GoogleTranslateApi.
    @Override
    public List<String> getLanguages() {
        return googleTranslateApi.getLanguages();
    }
}