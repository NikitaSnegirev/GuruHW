package parametericed;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import parametericed.data.Languages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class TwoTests {
    @ValueSource (strings = {
            "Aded", "Ivan"
    })
    @ParameterizedTest(name = "Find {0}")
    void RegistrationTest(String name) {
        open("https://cordtorg.ru/index.php?route=product/product&product_id=84");
        $("#input-quantity").setValue(name);
    }

    @CsvSource(value = {
            "Football ,Arsenal",
            "NFL, Arizona Cardinals"
    })
    @ParameterizedTest(name = "Click {0} find {1}")
    void Sport(String div, String h1) {
        open("https://shop.skysports.com/en/?_s=bm-fi-skysports-prtsite-web-homepage-header-en");
        $(byAttribute("alt", div)).click();
        $(byAttribute("alt", h1)).shouldHave(visible);
    }
    //не работает
    @EnumSource(Languages.class)
    @ParameterizedTest
    void SportLanguages(Languages languages) {
        open("https://shop.skysports.com/en/?_s=bm-fi-skysports-prtsite-web-homepage-header-en");
        $("#simple-dd").hover();
        $$(".dd-content.dd-open a").find(text(languages.name())).click();
        $("alt").shouldHave(text((languages.description)));



    }

}
