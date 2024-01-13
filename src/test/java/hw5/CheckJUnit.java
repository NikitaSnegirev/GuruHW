package hw5;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckJUnit {
    @Test
    void selenideInGit() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(byText("SoftAssertions")).click();  //.shouldBe(visible).click();
        $(".markdown-body").shouldBe(text("JUnit5 extension - com.codeborne.selenide.junit5.SoftAssertsExtension"));
    }
}