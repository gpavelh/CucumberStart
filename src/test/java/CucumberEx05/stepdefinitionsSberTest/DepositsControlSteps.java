package CucumberEx05.stepdefinitionsSberTest;

import CucumberEx05.pagesSberTest.DepositsControl;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class DepositsControlSteps {

    @Description("Проверка нахождения на странице \"Вклад управляй\"")
    @Допустим("проверка нахождения на странице {string} и инфой по вкладу {string}")
    public void checkDepositsControlPage(String titleName, String pageContent) {
        DepositsControl depositsControl = new DepositsControl();
        depositsControl
                .getTitle()
                .shouldHave(Condition.attribute("text", titleName));
        depositsControl.pageName.shouldHave(Condition.text(pageContent));
    }
}
