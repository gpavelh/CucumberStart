package CucumberEx05.pagesSberTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DepositsControl {

    public SelenideElement pageName = $(byXpath("//div[contains(@class, 'top_40')]//h2[.='Вклад Управляй']"));

    public SelenideElement getTitle() {
        return $("title");
    }
}
