package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterprizeHoverTest {

    @Test
    void solutionsEnterprizeHoverTest(){
        // открыть браузер на странице гитхаб
        open("https://github.com/");
        //нажать на Solutions
        $$("ul li").findBy(text("Solutions")).hover();
        //нажать на  Enterprize
        $$("ul li a").findBy(text("Enterprises")).click();
        //загрузилась нужная страница, заголовок: "The AI-powered developer platform."
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered" + "\n" + "developer platform"));
        //Configuration.holdBrowserOpen = true;
    }

}
