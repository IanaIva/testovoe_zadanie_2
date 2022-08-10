import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$x;

public class LaunchBrowser {
    @Test
    public void launchBrowserTest(){
        System.setProperty("selenide.browser", "firefox");
        open("https://www.google.ru/");
        $x("//input[@name='q']").setValue("Яна Ивашкова").pressEnter();
        $x("//div[@id='result-stats']").shouldBe(Condition.visible);
        $x("//a[text()='Картинки']").click();
        $$x("//img[@class='rg_i Q4LuWd']").size();
        $$x("//img[@class='rg_i Q4LuWd']").shouldHave(CollectionCondition.sizeGreaterThan(2));
        $$x("//img[@class='rg_i Q4LuWd']").get(2).click();
        $$x("//div[@jsname='vVws8e']").get(1).click();

    }

}
