package CucumberEx01.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSelenide {

    public void goToViewPage(String page) {
        $(By.xpath("//a[@id='bank-overview' and .= '"+page+"']")).click();
    }
}
