package hw6;


import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class Hover {

    @Test
    void HoverTest() {
        open("https://github.com/");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a", "Enterprise")).click();
        $("#scale").shouldHave(text("The enterprise-ready platform that developers know and love"));
    }

    @Test
    void MoveToElement() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($(byTagAndText("header","A"))).clickAndHold().moveByOffset(200, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").dragAndDrop(to("#column-a"));
        $("#column-a").shouldHave(text("A"));
    }
}
