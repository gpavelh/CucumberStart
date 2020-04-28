package CucumberEx04; //Домашка 29

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature/ex04",
        glue = {
                "CucumberEx04.stepdefinitionsAutoRuTest",
                "CucumberEx04.stepdefinitionsSberTest"
        },
        tags = "(@AutoRuAdTest and @second) or @SberDepTest"
)
public class StartPageTestConf extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void selenideConfigure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    void closeDriver() {
        closeWebDriver();
    }
}
