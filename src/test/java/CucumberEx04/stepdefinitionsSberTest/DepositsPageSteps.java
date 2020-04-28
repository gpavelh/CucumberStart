package CucumberEx04.stepdefinitionsSberTest;

import CucumberEx04.pagesSberTest.Deposits;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.switchTo;

public class DepositsPageSteps {
    Deposits deposits = new Deposits();

    @Description("Переход на вкладку \"Подобрать вклад\"")
    @Допустим("переходит на вкладку {string}")
    public void pickUpDepTab(String tapElement) {
        deposits.findTapElement(tapElement).click();
    }

    @Description("Проверка чекбосков")
    @Допустим("ползователь выполняет проверку отображения 4-ёх чек боксов")
    public void CheckBoxTest(List<String> checkBoxesList) {
        switchTo().frame("iFrameResizer0");
        for (int i = 0; i < checkBoxesList.size(); i++) {
            deposits.getCheckBoxElementName(checkBoxesList.get(i)).shouldHave(Condition.text(checkBoxesList.get(i)));
        }
    }

    @Description("Провека установки чек-бокса \"Онайлн\"")
    @Допустим("пользователь проверяет установку чек-бокса {string}")
    public void chooseCheckBox(String checkBox) {
        deposits.chooseCheckBoxElement(checkBox).shouldBe(Condition.attribute("aria-checked", "true"));
    }

    @Description("Проверка чек-босков")
    @Допустим("пользователь проверяет отображение 3-х вкладов:")
    public void depositsCheck(List<String> depositsList) {
        for (int i = 0; i < depositsList.size(); i++) {
            deposits.getDepositsName(depositsList.get(i)).shouldHave(Condition.text(depositsList.get(i)));
        }
    }

    @Step("Выбор условий")
    @Допустим("выбирает следущие чекбоксы:")
    public void chooseCheckBox(List<String> checkBoxes) {
        deposits.chooseCheckBoxElement(checkBoxes.get(0)).click();
        deposits.chooseCheckBoxElement(checkBoxes.get(1)).click();
    }

    @Step("Проверка наличия только вклада \"Управляй\"")
    @Допустим("пользователь проверяет наличие только вклада {string}")
    public void checkDepCount(String depositsName) {
        deposits.getDeposits()
                .shouldHaveSize(1)
                .shouldHave(CollectionCondition.texts(depositsName));
    }

    @Step("Переход на страницу с подробностями")
    @Допустим("нажимает на кнопку \"Подробнее\"")
    public void pushInfoButton() {
        deposits.infoButton.click();
        switchTo().window(1);
    }
}
