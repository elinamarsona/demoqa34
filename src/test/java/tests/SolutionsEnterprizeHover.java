package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class SolutionsEnterprizeHover {

    @Test
    void SolutionsEnterprizeHoverTest(){
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
