package CucumberEx03.stepdefinitions;

import CucumberEx03.pages.MainPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {

    public static String countAd;

    MainPage mainPage = new MainPage();

    @Step("Открываем сайт авто.ру")
    @Допустим("пользователь заходит на авто.ру")
    public void openSite() {
        open("https://auto.ru/");
        $("title").shouldHave(Condition.attribute("text", "Авто.ру: купить, продать и обменять машину"));
    }

    @Step("Нажимаем на кнопку \"Все марки\"")
    @Допустим("нажимает на кнопку \"Все марки\"")
    public void allBrands() {
        mainPage.allBrandButton.click();
    }

    @Step("Сохраняем кол-во объявлений по марке {string}")
    @Допустим("^сохраняет кол-во авто в объявлении по марке (.*)")
    public void saveCountAd(String brand) {
        countAd = mainPage.getCarAd(brand);
        System.out.println("Количество объявлений по марке на главной " + brand + ": " + countAd);
    }

    @Step("Переходим на страницу марки {string}")
    @Допустим("^нажимает на кнопку с маркой автомобиля (.*)")
    public void goToCarBrandPage(String brand) {
        mainPage.carBrandPage(brand).click();
    }
}
