package CucumberEx04.stepdefinitionsAutoRuTest;

import CucumberEx04.pagesAutoRuTest.BrandPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class BrandPageSteps {

    private static final Logger LOG = LoggerFactory.getLogger(BrandPageSteps.class);
    public static String modelCount;

    BrandPage brandPage = new BrandPage();

    @Description("Сравниваем значение полученное на главной со значением указанным на кнопке \"Показать\"")
    @Допустим("и сравнивает полученое значение с кол-ом объявлений по марке в кнопке \"Показать\"")
    public void getAdCount() {
        brandPage.brandPageViewButton.shouldBe(Condition.visible);
        MainPageSteps mainPageSteps = new MainPageSteps();
        Assert.assertEquals(mainPageSteps.countAd, brandPage.adCount());
        LOG.info("Количество объявлений по марке на странице бренда : " + brandPage.adCount());
    }

    @Description("Сохраняем кол-во объявлений по модели {string}")
    @Допустим("сохраняет кол-во авто в объявлении по модели {string}")
    public void saveModelCount(String model) {
        modelCount = brandPage.getModelCount(model);
        LOG.info("Количество объявлений по модели " + model + " на странице бренда : " + modelCount);
    }

    @Description("Переходим на страницу модели {string}")
    @Допустим("нажимает на кнопку с моделью {string}")
    public void goToModelPage(String model) {
        brandPage.modelPage(model).click();
    }
}
