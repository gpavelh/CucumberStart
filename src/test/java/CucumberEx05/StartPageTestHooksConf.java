package CucumberEx05; //Домашка 30

import CucumberEx05.config.ConfReader;
import CucumberEx05.config.PropertiesReader;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature/ex05",
        glue = {
                "CucumberEx05.stepdefinitionsAutoRuTest",
                "CucumberEx05.stepdefinitionsSberTest"
        },
        tags = "(@AutoRuAdTest and @second) or @SberDepTest"
)
public class StartPageTestHooksConf extends AbstractTestNGCucumberTests {

    private ConfReader confReader = new PropertiesReader();

    @BeforeMethod
    public void selenideConfigure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.browser = (confReader.getValue("browser"));
        Configuration.clickViaJs = (confReader.getBooleanValue("clickViaJs"));
        Configuration.startMaximized = (confReader.getBooleanValue("startMaximized"));
    }

    @AfterMethod
    void closeDriver() {
        WebDriverRunner.getWebDriver().close();
    }
}
