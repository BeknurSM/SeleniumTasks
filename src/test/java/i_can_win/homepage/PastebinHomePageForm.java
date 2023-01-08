package i_can_win.homepage;

import i_can_win.util.LocatorCreator;
import i_can_win.util.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static i_can_win.util.Waitings.waitForElementToBeClickable;

public class PastebinHomePageForm extends PastebinHomePage{

    @FindBy (id = "postform-text")
    private WebElement textPostform;

    @FindBy (id = "select2-postform-expiration-container")
    private WebElement expirationDropDownList;

    @FindBy (id = "postform-name")
    private WebElement namePostform;

    @FindBy (xpath = "//button[@class='btn -big']")
    private WebElement createPasteButton;

    public PastebinHomePageForm(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePageForm fillTextForm(String text) {
        Waitings.waitForElementToBeClickable(textPostform, driver);
        textPostform.sendKeys(text);
        return this;
    }

    public PastebinHomePageForm openExpirationDropDownList() {
        Waitings.waitForElementToBeClickable(expirationDropDownList, driver);
        expirationDropDownList.click();
        return this;
    }

    public PastebinHomePageForm insertExpiration(String expiration) {
        WebElement element = driver.findElement(By.xpath(LocatorCreator.createXPath(LocatorCreator.BASE_LOCATOR, expiration)));
        Waitings.waitForElementToBeClickable(element, driver);
        element.click();
        return this;
    }

    public PastebinHomePageForm insertPasteName(String name) {
        Waitings.waitForElementToBeClickable(namePostform, driver);
        namePostform.sendKeys(name);
        return this;
    }

    public PastebinHomePageForm createNewPaste () {
        Waitings.waitForElementToBeClickable(createPasteButton, driver);
        createPasteButton.click();
        return this;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }
}