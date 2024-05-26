import com.assignment.question.GoogleTranslationProviderAdapterImpl;
import com.assignment.question.MicrosoftTranslationProviderAdapterImpl;
import com.assignment.question.TranslationProviderAdapter;
import com.assignment.question.TranslationRequest;

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