package CucumberEx01.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSelenide {

    public void goToViewPage() {
        $(By.xpath("//a[@id='bank-overview' and .= 'Обзор']")).click();
    }
}
