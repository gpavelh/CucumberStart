package CucumberEx04.pagesAutoRuTest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public SelenideElement allBrandButton = $(byXpath("//div[text() = 'Все марки']"));

    public SelenideElement carBrandPage(String brand) {
        return $(byXpath("//a[div[text() = '" + brand + "']]"));
    }

    public String getCarAd(String brand) {
        return $(byXpath("//a[div[text() = '" + brand + "']]/div[contains(@class,'count')]")).getText();
    }

    public void closeStupidWindow() {
        $(byXpath("//span[span[text()='Понятно, спасибо']]")).waitUntil(Condition.visible,5000).doubleClick();
    }

    public void locationMoscow()  {
        if (!$(byXpath("//span[@class ='GeoSelect__title-shrinker']")).getText().equals("Москва")) {
            $(byXpath("//span[@class ='GeoSelect__title-shrinker']")).click();
            $(byXpath("//div/label")).sendKeys("Москва");
            $(byXpath("//div[@class ='GeoSelectPopup__suggest-item-content']/div[contains(text(),'Москва')]")).click();
            $(byXpath("//button[span[.='Сохранить']]/span/span")).hover().doubleClick();
        }
    }
}
