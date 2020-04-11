package CucumberEx03.pages;

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
}
