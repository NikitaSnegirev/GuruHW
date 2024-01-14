package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultRegistrationComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            HobbiesInput = $("#hobbiesWrapper"),
            PictureUpload = $("#uploadPicture"),
            CurrentAddressInput = $("#currentAddress"),
            StateClick = $("#state"),
            StateSelect = $("#stateCity-wrapper"),

            CityClick = $("#city"),
            CitySelect = $("#stateCity-wrapper"),
            SumbitClick = $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultRegistrationComponent resultRegistrationComponent = new ResultRegistrationComponent();
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbiesInput(String value) {
        HobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setPicture() {
        PictureUpload.uploadFromClasspath("jpg/photo.jpg");

        return this;
    }

    public RegistrationPage setCurrentAddress(String value) {
        CurrentAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState (String value) {
        StateClick.click();
        StateSelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity (String value) {
        CityClick.click();
        CitySelect.$(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSumbit() {
        SumbitClick.click();

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        resultRegistrationComponent.checkPositiveResult(key, value);

        return this;
    }

    public RegistrationPage checkAbsenceResult() {
        resultRegistrationComponent.checkNegativeResult();

        return this;
    }

}
