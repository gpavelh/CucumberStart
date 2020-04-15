package CucumberEx05.pagesAutoRuTest;

import com.codeborne.selenide.SelenideElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ModelPage {

    public SelenideElement modelPageViewButton = $(byXpath("//span[contains(text(),'предложен')]"));

    public String adModelCount() {
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
}
