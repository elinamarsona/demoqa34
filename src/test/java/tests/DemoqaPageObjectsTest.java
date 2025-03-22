package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Elina";
    String lastName = "Kulikova";
    String userEmail = "elina@kulikova.com";
    String gender = "Female";
    String userNumber = "8888888881";
    String month = "December";
    String year = "1991";
    String day = "17";
    String subject = "Computer";
    String hobbies = "Sports";
    String uploadImage = "2.jpg";
    String currentAddress = "street LA";
    String state = "Rajasthan";
    String city = "Jaiselmer";

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDay(day, month, year)
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(uploadImage)
                .setAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", "2.jpg")
                .checkResult("Address", currentAddress)
                .checkResult("State and City", state + " " + city);
    }

    @Test
    void successRegistrationMinimalInputTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(gender)
                .setUserNumber(userNumber)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber);
    }

    @Test
    void negativeRegistrationTest1() {
        registrationPage.openPage()
                .submitForm();

        registrationPage.checkInvalidInput();
    }

    @Test
    void negativeRegistrationTest2() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .submitForm();

        registrationPage.checkInvalidInput();
    }

}
