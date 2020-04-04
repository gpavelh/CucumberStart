package CucumberEx01.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class ViewPageSelenide {

    public SelenideElement amount = $(By.xpath("//span[@class = 'amount']"));
    public SelenideElement myMoney = $(By.xpath("//small[@class = 'my-assets']"));
    public SelenideElement textViewPage = $(By.xpath ("//div/span[contains(text(),'свобода')]"));



    public void moveToAmount(SelenideElement element) {
        Actions actions = new Actions(getWebDriver());
        actions.moveToElement(element).build().perform();
    }
}
