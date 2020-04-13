package CucumberEx03.stepdefinitions;

import CucumberEx03.pages.BrandPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Step;
import org.testng.Assert;

public class BrandPageSteps {

    public static String modelCount;

    BrandPage brandPage = new BrandPage();

    @Step("Сравниваем значение полученное на главной со значением указанным на кнопке \"Показать\"")
    @Допустим("и сравнивает полученое значение с кол-ом объявлений по марке в кнопке \"Показать\"")
    public void getAdCount() {
        brandPage.brandPageViewButton.shouldBe(Condition.visible);
        MainPageSteps mainPageSteps = new MainPageSteps();
        Assert.assertEquals(mainPageSteps.countAd, brandPage.adCount());
        System.out.println("Количество объявлений по марке на странице бренда : " + brandPage.adCount());
    }

    @Step("Сохраняем кол-во объявлений по модели {string}")
    @Допустим("сохраняет кол-во авто в объявлении по модели {string}")
    public void saveModelCount(String model) {
        modelCount = brandPage.getModelCount(model);
        System.out.println("Количество объявлений по модели " + model + " на странице бренда : " + modelCount);
    }

    @Step("Переходим на страницу модели {string}")
    @Допустим("нажимает на кнопку с моделью {string}")
    public void goToModelPage(String model) {
        brandPage.modelPage(model).click();
    }
}
