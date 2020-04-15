package CucumberEx05.pagesSberTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public void checkLang() {
        if ($(byXpath("//a[.='РУС']")).getText().equals("РУС")) {
            $(byXpath("//a[.='РУС']")).click();
        }
    }

    public SelenideElement findTopMenuElement(String name) {
        return $(byXpath("//span[.='" + name + "']"));
    }

    public SelenideElement findDropOutMenuElement(String name) {
        return $(byXpath("//a[.='" + name + "']"));
    }
}
