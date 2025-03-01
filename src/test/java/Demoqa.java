package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Demoqa {

    String firstName = "Elina";
    String lastName = "Kulikova";
    String userEmail = "elina@kulikova.com";
    String gender = "Female";
    String userNumber = "8888888881";
    String month = "December";
    String year = "1991";
    String day = "17";
    String subjectsInput = "Computer";
    String checkbox1 = "Sports";
    String checkbox2 = "Reading";
    String checkbox3 = "Music";
    String file = "src\\test\\java\\2.jpg";
    String currentAddress = "street LA";
    String state = "Rajasthan";
    String city = "Jaiselmer";


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
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#gender-radio-2").parent().$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").setValue(subjectsInput).pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText(checkbox1)).click();
        $("#hobbies-checkbox-2").parent().$(byText(checkbox2)).click();
        $("#hobbies-checkbox-3").parent().$(byText(checkbox3)).click();
        $("#uploadPicture").uploadFile(new File(file));
        $("#currentAddress").scrollTo();
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $(byText(state)).click();
        $("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(gender));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(day + " " + month + "," + year));
        $(".table-responsive").shouldHave(text(subjectsInput));
        $(".table-responsive").shouldHave(text(checkbox1 + ", " + checkbox2 + ", " + checkbox3));
        $(".table-responsive").shouldHave(text(file.substring(14)));

    }


}
