package CucumberEx01.stepdefinitions;

import CucumberEx01.pages.CodeZoneSelenide;
import CucumberEx01.pages.LoginSelenide;
import CucumberEx01.pages.MainPageSelenide;
import CucumberEx01.pages.ViewPageSelenide;
import com.codeborne.selenide.Condition;
import io.cucumber.java.ru.Допустим;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Spliterator;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class formatCheckTest {
    @Допустим("Пользователь заходит на сайт банка")
    public void openSite() {
        open("https://idemo.bspb.ru:");
    }

    @Допустим("Проверить язык и сменить если потребуется и залогиниться используя логин {string} и пароль {string}")
    public void checkLang(String log, String pass) {
        LoginSelenide loginSelenide = new LoginSelenide();
        loginSelenide.checkLang();
        loginSelenide.loginToSite(log, pass);
    }

    @Допустим("Веести код авторизации {string}")
    public void enterAuthCode(String code) {
        CodeZoneSelenide codeZoneSelenide = new CodeZoneSelenide();
        $(By.id("otp-code-text")).shouldHave(text(("был отправлен код подтверждения, введите его для входа")));
        codeZoneSelenide.enterAuthCode(code);
    }

    @Допустим("Перейти на страницу {string}")
    public void goToViewPage(String page) {
        MainPageSelenide mainPage = new MainPageSelenide();
        $(By.xpath("//div[contains(text(),'Генеральная лицензия Банка России')]")).shouldHave(text("Генеральная лицензия Банка России"));
        mainPage.goToViewPage(page);
    }

    @Допустим("Навести курсор на сумму в блоке \"Финансовая свобода\"")
    public void moveToFinance() {
        ViewPageSelenide viewPage = new ViewPageSelenide();
        Assert.assertTrue(viewPage.textViewPage.isDisplayed());
        viewPage.amount.shouldBe(Condition.matchesText("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{0,2}\\s\\D"));
        viewPage.moveToAmount(viewPage.amount);
    }

    @Допустим("Проверить формат суммы")
    public void amountFormatCheck() {
        ViewPageSelenide viewPage = new ViewPageSelenide();
        viewPage.myMoney.shouldBe(Condition.matchesText("\\d{0,3}\\s\\d{0,3}\\s\\d{0,3}\\.\\d{0,2}\\s\\D"));
    }
}