package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.TypeOptions.text;

public class SelenideWikiSoftAssertions {

    @Test
    void selenideWikiSoftAssertionsTest(){
        //открыть страницу https://github.com/selenide/selenide
        open("https://github.com/selenide/selenide");
        //найти wiki и кликнуть на него
        $("#wiki-tab").click();
        //найти Soft assertions и кликнуть на него
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();

        //проверка: наличие примера кода для JUnit5
        $("body").shouldHave(Condition.text("""
                        @ExtendWith({SoftAssertsExtension.class})
                        class Tests {
                          @Test
                          void test() {
                            Configuration.assertionMode = SOFT;
                            open("page.html");
                        
                            $("#first").should(visible).click();
                            $("#second").should(visible).click();
                          }
                        }"""));


    }

}
