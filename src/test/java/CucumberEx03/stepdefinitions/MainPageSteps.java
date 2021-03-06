package CucumberEx03.stepdefinitions;

import CucumberEx03.pages.MainPage;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {

    private static final Logger LOG = LoggerFactory.getLogger(MainPageSteps.class);
    public static String countAd;

    MainPage mainPage = new MainPage();

    @Description("Открываем сайт авто.ру")
    @Допустим("пользователь заходит на авто.ру")
    public void openSite() {
        open("https://auto.ru/");
        Assert.assertTrue(WebDriverRunner.getWebDriver().getTitle().contains("Авто.ру:"));
        mainPage.closeStupidWindow();
        mainPage.locationMoscow();
    }

    @Description("Нажимаем на кнопку \"Все марки\"")
    @Допустим("нажимает на кнопку \"Все марки\"")
    public void allBrands() {
        mainPage.allBrandButton.click();
    }

    @Description("Сохраняем кол-во объявлений по марке {string}")
    @Допустим("сохраняет кол-во авто в объявлении по марке {string}")
    public void saveCountAd(String brand) {
        countAd = mainPage.getCarAd(brand);
        LOG.info("Количество объявлений по марке на главной " + brand + ": " + countAd);
    }

    @Description("Переходим на страницу марки {string}")
    @Допустим("нажимает на кнопку с маркой автомобиля {string}")
    public void goToCarBrandPage(String brand) {
        mainPage.carBrandPage(brand).click();
    }
}
