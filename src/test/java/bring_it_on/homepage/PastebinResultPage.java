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
    private static final String TEXT_CONTENT_SELECTOR = "//pre[@style]";
    private static final String FORMAT_SELECTOR = "(//*[contains(@href, 'bash')])[2]";


    @FindBy(xpath = "//a[text()='raw']")
    private WebElement rawButton;

    public PastebinResultPage(WebDriver driver) {
        super(driver);
    }

    public static String getTittleName(WebDriver driver) {
        return getTextFromElementByXPath(TITLE_NAME_SELECTOR, driver);
    }

    public String tittleName() {
        return driver.findElement(By.xpath(TITLE_NAME_SELECTOR)).getText();

    }

    public PastebinResultPage clickRawButton(){
        waitForElementToBeClickable(rawButton,driver);
        rawButton.click();
        return this;
    }

    public String getTextContent() {
        return getTextFromElementByCSS(TEXT_CONTENT_SELECTOR,driver);
    }

    public static String getHighlightedSyntax(WebDriver driver) {
        return getTextFromElementByXPath(FORMAT_SELECTOR,driver);
    }
}
