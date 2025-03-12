package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void dragAndDropTest(){
        //открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //перенести прямоугольник А на место В
        $("#column-a").dragAndDropTo("#column-b");
        //проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void ActionTest(){
        //открыть https://the-internet.herokuapp.com/drag_and_drop
        open("https://the-internet.herokuapp.com/drag_and_drop");
        // Подвинуть прямоугольник А, кликнуть и держать, передвинуть на место В, отпустить кнопку мыши
        actions().moveToElement($("#column-a")).clickAndHold().moveToElement($("#column-b"))
                .release().perform();
        //проверить, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}
