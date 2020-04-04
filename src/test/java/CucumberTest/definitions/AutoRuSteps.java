package CucumberTest.definitions;

import io.cucumber.java.ru.Допустим;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class AutoRuSteps {

    @Допустим("открывается новая вкладка авто.ру")
    public void openNewWindow() {
        new WebDriverWait(getWebDriver(), 30, 5)
                .until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Допустим("пользователь переключается на новую вкладку")
    public void switchToNewWindow() {
        String mainWindow = getWebDriver().getWindowHandle();
        for (String handle : getWebDriver().getWindowHandles()) {
            if (handle != mainWindow)
                getWebDriver().switchTo().window(handle);
        }
    }

    @Допустим("пользователь выбирает bmw в списке автомобилей")
    public void bmwSelect() {
        $(byXpath("//a/div[.='BMW']")).click();
    }

    @Допустим("пользователь выбирает модель 5-ой серии")
    public void allBmwCarsView() {
        $(byXpath("//a[.='5 серия']")).click();
    }
}
