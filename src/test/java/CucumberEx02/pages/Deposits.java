package CucumberEx02.pages;


import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Deposits {
    public SelenideElement infoButton = $(byXpath("//a[.='Подробнее']"));

    public SelenideElement findTapElement(String name) {
        return $(byXpath("//a[.='" + name + "']"));
    }

    public SelenideElement chooseCheckBoxElement(String name) {
        return $(byXpath("//label[.='" + name + "']/input"));
    }

    public SelenideElement getCheckBoxElementName(String name) {
        return $(byXpath("//div[.='" + name + "']"));
    }

    public SelenideElement getDepositsName(String name) {
        return $(byXpath("//h3[contains(text(),'" + name + "')]"));
    }

    public ElementsCollection getDeposits() {
        return $$(byXpath("//div[@class = 'ds-form__products-wrapper']//h3[@class= 'offered-products__header']"));
    }
}
