package CucumberTest.definitions;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Yandex {

    @Допустим("пользователь заходит на яндекс")
    public void yandexOpen() {
        Selenide.open("https://yandex.ru/");
    }

    @Допустим("пользователь переходит на авто.ру через меню")
    public void findAutoRuInMenu() {
        $(byXpath("//a[.='ещё']")).click();
        $(byXpath("//a[.='Авто.ру']")).click();
    }
}
