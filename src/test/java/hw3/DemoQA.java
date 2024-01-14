package hw3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoQA {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Smirnov");
        $("#userEmail").setValue("alex@egorov.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText ("September")).click();
        $(".react-datepicker__year-select").click();
        $(byText ("1997")).click();
        $(byText ("13")).click();
        $("#subjectsInput").setValue("A");
        $("#react-select-2-option-0").click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("C:/Users/New/Pictures/photo.jpg"));
        $("#currentAddress").setValue("Comm");
        $(byText("Select State")).click();
        $("#react-select-3-option-2").click();
        $(byText("Select City")).click();
        $(byText("Panipat")).click();
        $("#submit").click();

        $$("tbody tr").get(0).shouldHave(text("Alex Smirnov"));
        $$("tbody tr").get(1).shouldHave(text("alex@egorov.com"));
        $$("tbody tr").get(2).shouldHave(text("Male"));
        $$("tbody tr").get(3).shouldHave(text("1234567890"));
        $$("tbody tr").get(4).shouldHave(text("13 September,1997"));
        $$("tbody tr").get(5).shouldHave(text("Maths"));
        $$("tbody tr").get(6).shouldHave(text("Music"));
        $$("tbody tr").get(7).shouldHave(text("photo.jpg"));
        $$("tbody tr").get(8).shouldHave(text("Comm"));
        $$("tbody tr").get(9).shouldHave(text("Haryana Panipat"));
    }
}