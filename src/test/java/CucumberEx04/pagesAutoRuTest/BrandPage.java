package CucumberEx04.pagesAutoRuTest;


import com.codeborne.selenide.SelenideElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BrandPage {

    public SelenideElement brandPageViewButton = $(byXpath("//span[contains(text(),'предложен')]"));

    public String adCount() {
        String text = $(byXpath("//span[contains(text(),'предложен')]")).getText();
        Pattern pattern = Pattern.compile("\\d+");
        String word = text.replace(" ", "");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            String count = matcher.group();
            return count;
        }
        return text;
    }

    public SelenideElement modelPage(String model) {
        return $(byXpath("//a[text() = '" + model + "']"));
    }

    public String getModelCount(String model) {
        return $(byXpath("//div[a[text() = '" + model + "']]/div")).getText();
    }
}
