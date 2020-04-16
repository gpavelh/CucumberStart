package CucumberTest;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(
        plugin = "json:target/cucumber-report.json",
        features = "src/test/resources/feature/test",
        glue = {"CucumberTest.definitions"}
)
public class CucTest extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void selenideConfigure() {
        Configuration.browser = "chrome";
        Configuration.clickViaJs = true;
        Configuration.startMaximized = true;
    }
}
