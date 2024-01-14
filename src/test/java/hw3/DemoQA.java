package hw3;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoQA extends BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulFullRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Smirnov")
                .setEmail("alex@egorov.com")
                .setGender("Male")
                .setUserNumber("1234567890")
                .setDateOfBirth("30", "July", "2008")
                .setSubjects("Math")
                .setHobbiesInput("Sports")
                .setPicture()
                .setCurrentAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .clickSumbit()

                .checkResult("Student Name", "Alex Smirnov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");
    }

    @Test
    void successfulMinRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Smirnov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .clickSumbit()

                .checkResult("Student Name", "Alex Smirnov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890");
    }
    @Test
    void failedRegistration() {
        registrationPage.openPage()
                .clickSumbit()

                .checkAbsenceResult();


    }
}