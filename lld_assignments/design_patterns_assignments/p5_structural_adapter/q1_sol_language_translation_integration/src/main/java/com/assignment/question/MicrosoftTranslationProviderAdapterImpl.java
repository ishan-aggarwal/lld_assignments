package com.assignment.question;

import com.assignment.question.external.*;

import java.util.*;

public class MicrosoftTranslationProviderAdapterImpl implements TranslationProviderAdapter {

    private MicrosoftTranslateApi microsoftTranslateApi = new MicrosoftTranslateApi();

    @Override
    public String convert(TranslationRequest request) {
        return microsoftTranslateApi.translate(request.getText(), request.getSourceLanguage(), request.getTargetLanguage());
    }

    @Override
    public List<String> getLanguages() {
        return microsoftTranslateApi.getSupportedLanguages();
    }
}