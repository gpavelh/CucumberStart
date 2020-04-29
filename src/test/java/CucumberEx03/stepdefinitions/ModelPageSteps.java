package CucumberEx03.stepdefinitions;

import CucumberEx03.pages.BrandPage;
import CucumberEx03.pages.ModelPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ModelPageSteps {

    private static final Logger LOG = LoggerFactory.getLogger(ModelPageSteps.class);
    ModelPage modelPage = new ModelPage();

    @Description("Сравниваем значение полученное на главной со значением указанным на кнопке \"Показать\"")
    @Допустим("и сравнивает полученое значение с кол-ом объявлений по модели в кнопке \"Показать\"")
    public void getAdModelCount() {
        modelPage.modelPageViewButton.shouldBe(Condition.visible);
        BrandPageSteps brandPageSteps = new BrandPageSteps();
        Assert.assertEquals(brandPageSteps.modelCount,modelPage.adModelCount());
        LOG.info("Количество объявлений по модели на странице модели : " + modelPage.adModelCount());
    }
}
