package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultRegistrationComponent {
    private SelenideElement ResultRegistration = $(".table-responsive");
    public void checkPositiveResult(String key, String value) {
        ResultRegistration.$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void checkNegativeResult() {
        ResultRegistration.shouldNotBe(exist);
    }
}
