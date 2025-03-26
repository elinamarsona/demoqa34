package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import java.util.Locale;

public class DemoqaPageObjectsFakerTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void successRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setUserEmail(randomUtils.userEmail)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .setBirthDay(randomUtils.day, randomUtils.month, randomUtils.year)
                .setSubjects(randomUtils.subject)
                .setHobbies(randomUtils.hobbies)
                .setPicture(randomUtils.uploadImage)
                .setAddress(randomUtils.currentAddress)
                .setStateAndCity(randomUtils.state, randomUtils.city)
                .submitForm();

        registrationPage.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                .checkResult("Student Email", randomUtils.userEmail)
                .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.userNumber)
                .checkResult("Date of Birth", randomUtils.day + " " + randomUtils.month + "," + randomUtils.year)
                .checkResult("Subjects", randomUtils.subject)
                .checkResult("Hobbies", randomUtils.hobbies)
                .checkResult("Picture", "2.jpg")
                .checkResult("Address", randomUtils.currentAddress)
                .checkResult("State and City", randomUtils.state + " " + randomUtils.city);
    }

    @Test
    void successRegistrationMinimalInputTest() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .setLastName(randomUtils.lastName)
                .setGender(randomUtils.gender)
                .setUserNumber(randomUtils.userNumber)
                .submitForm();

        registrationPage.checkResult("Student Name", randomUtils.firstName + " " + randomUtils.lastName)
                 .checkResult("Gender", randomUtils.gender)
                .checkResult("Mobile", randomUtils.userNumber);
    }

    @Test
    void negativeRegistrationTest1() {
        registrationPage.openPage()
                .removeBanner()
                .submitForm();

        registrationPage.checkInvalidInput();
    }

    @Test
    void negativeRegistrationTest2() {
        registrationPage.openPage()
                .removeBanner()
                .setFirstName(randomUtils.firstName)
                .submitForm();

        registrationPage.checkInvalidInput();
    }

}
