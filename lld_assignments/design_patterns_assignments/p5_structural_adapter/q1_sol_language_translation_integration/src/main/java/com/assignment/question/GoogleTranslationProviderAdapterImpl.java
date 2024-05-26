package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

public class GoogleTranslationProviderAdapterImpl implements TranslationProviderAdapter {

    private GoogleTranslateApi googleTranslateApi = new GoogleTranslateApi();

    @Override
    public String convert(TranslationRequest request) {
        GoogleTranslationRequest googleTranslationRequest = new GoogleTranslationRequest(request.getText(),
                request.getSourceLanguage(),
                request.getTargetLanguage(),
                request.getConfidenceThreshold()
        );
        return googleTranslateApi.convert(googleTranslationRequest);
    }

    @Override
    public List<String> getLanguages() {
        return googleTranslateApi.getLanguages();
    }
}