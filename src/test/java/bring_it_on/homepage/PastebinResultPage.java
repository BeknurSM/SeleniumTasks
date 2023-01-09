package bring_it_on.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Service;

import static bring_it_on.util.Utils.getTextFromElementByCSS;
import static bring_it_on.util.Utils.getTextFromElementByXPath;
import static bring_it_on.util.Waitings.waitForElementToBeClickable;

@Service
public class PastebinResultPage extends PastebinHomePage {
    private static final String TITLE_NAME_SELECTOR = "//h1";
    private static final String TEXT_CONTENT_SELECTOR = "/html/body/pre";
    private static final String FORMAT_SELECTOR = "(//*[contains(@href, 'bash')])[2]";

    private final By syntax = By.cssSelector("div.left > a");

    @FindBy(xpath = "//a[text()='raw']")
    private WebElement rawButton;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public static String getTittleName(WebDriver driver) {
        return getTextFromElementByXPath(TITLE_NAME_SELECTOR, driver);
    }

    public String getSyntaxHighlight() {
        return waitPresenceOfElementLocated(syntax).getText();
    }
    public PastebinResultPage clickRawButton(){
        waitForElementToBeClickable(rawButton,driver);
        rawButton.click();
        return this;
    }

    public static String getTextContent(WebDriver driver) {
        return getTextFromElementByXPath(TEXT_CONTENT_SELECTOR, driver);
    }


}
