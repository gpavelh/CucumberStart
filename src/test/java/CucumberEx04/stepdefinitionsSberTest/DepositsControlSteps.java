package CucumberEx04.stepdefinitionsSberTest;

import CucumberEx04.pagesSberTest.DepositsControl;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Step;

public class DepositsControlSteps {

    @Step("Проверка нахождения на странице \"Вклад управляй\"")
    @Допустим("проверка нахождения на странице {string} и инфой по вкладу {string}")
    public void checkDepositsControlPage(String titleName, String pageContent) throws InterruptedException {
        DepositsControl depositsControl = new DepositsControl();
        depositsControl
                .getTitle()
                .shouldHave(Condition.attribute("text", titleName));
        Thread.sleep(50000);
        depositsControl.pageName.shouldHave(Condition.text(pageContent));
    }
}
