package CucumberEx02.stepdefinitions;

import CucumberEx02.pages.MainPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPageSteps {
    MainPage mainPage = new MainPage();

    @Step("Переход на сайт Сбербанка")
    @Допустим("пользователь заходит на сайт СберБанка")
    public void goToSberPage() {
        Selenide.open("https://www.sberbank.ru");
    }

    @Step("Проверка языка")
    @Допустим("если сайт на английском, то меняет язык на русский")
    public void langCheck() {
        mainPage.checkLang();
        $("title").shouldHave(Condition.attribute("text", "«Сбербанк» - Частным клиентам"));
    }

    @Step("Переход на страницу \"Вклады\"")
    @Допустим("на верхней панеле наводит на {string} и в выпадающем меню нажимает на кнопку {string}")
    public void goToTab(String topMenu, String dropOutMenu) throws InterruptedException {
        mainPage.findTopMenuElement(topMenu).hover();
        mainPage.findDropOutMenuElement(dropOutMenu).click();
        $("title").shouldHave(Condition.attribute("text", "«Сбербанк» - Подбор вкладов"));
    }
}
