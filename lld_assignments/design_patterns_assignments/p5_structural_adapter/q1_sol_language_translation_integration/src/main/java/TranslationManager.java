import com.assignment.question.GoogleTranslationProviderAdapterImpl;
import com.assignment.question.MicrosoftTranslationProviderAdapterImpl;
import com.assignment.question.TranslationProviderAdapter;
import com.assignment.question.TranslationRequest;


// The design pattern used here is the Adapter Pattern.
// This pattern allows objects with incompatible interfaces to collaborate.
// It’s often used when you want to make existing classes work with others without modifying their source code.

public class TranslationManager {

    private TranslationProviderAdapter googleTranslationProviderAdapter = new GoogleTranslationProviderAdapterImpl();
    private TranslationProviderAdapter microsoftTranslationProviderAdapter = new MicrosoftTranslationProviderAdapterImpl();

    public String translate(String text, String sourceLanguage, String targetLanguage, String provider) {
        if (provider.equals("google")) {
            TranslationRequest request = new TranslationRequest(text, sourceLanguage, targetLanguage, 0.8);
            return googleTranslationProviderAdapter.convert(request);
        } else if (provider.equals("microsoft")) {
            TranslationRequest request = new TranslationRequest(text, sourceLanguage, targetLanguage, 0.8);
            return microsoftTranslationProviderAdapter.convert(request);
        } else {
            throw new RuntimeException("Invalid provider");
        }
    }
}

/*
    In this code, the TranslationProviderAdapter interface defines operations that all concrete translation adapters must implement.
    The GoogleTranslationAdapter and MicrosoftTranslationAdapter classes are adapters for the GoogleTranslateApi and MicrosoftTranslateApi classes, respectively.
    They implement the TranslationProviderAdapter interface and adapt the interfaces of the GoogleTranslateApi and MicrosoftTranslateApi classes to the TranslationProviderAdapter interface.

    This is a classic implementation of the Adapter Pattern.
    The Adapter Pattern is a structural design pattern that allows objects to collaborate that couldn’t otherwise because of incompatible interfaces.
 */