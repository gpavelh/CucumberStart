package CucumberEx03; //Домашка 28

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
        features = "src/test/resources/feature/ex03",
        glue = {"CucumberEx03.stepdefinitions"}
)
public class StartAutoRuTestConf extends AbstractTestNGCucumberTests {

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
