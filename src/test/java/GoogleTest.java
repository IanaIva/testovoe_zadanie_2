import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.*;

public class GoogleTest {
    @Test
    public void testSearchGoogle() throws FileNotFoundException, InterruptedException {
        open("https://www.google.ru/");
        $x("//input[@name='q']").setValue("Яна Ивашкова").pressEnter();
        $x("//div[@id='result-stats']").shouldBe(Condition.visible);
        $x("//a[text()='Картинки']").click();
        $$x("//img[@class='rg_i Q4LuWd']").size();
        $$x("//img[@class='rg_i Q4LuWd']").shouldHave(CollectionCondition.sizeGreaterThan(2));
        $$x("//img[@class='rg_i Q4LuWd']").get(2).click();
        Thread.sleep(1000);
        $$x("//div[@jsname='vVws8e']").get(1).click();
        Thread.sleep(3000);


    }

}
