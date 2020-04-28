package CucumberEx02; //Домашка 27

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature/ex02",
        glue = {"CucumberEx02.stepdefinitions"}
)
public class StartSberTestConf extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void selenideConfigure() {
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
    }

    @AfterMethod
    void closeDriver() {
        closeWebDriver();
    }
}
