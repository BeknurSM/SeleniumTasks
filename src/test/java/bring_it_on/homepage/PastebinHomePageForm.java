package bring_it_on.homepage;

import bring_it_on.util.LocatorCreator;
import bring_it_on.util.Waitings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static bring_it_on.util.LocatorCreator.BASE_LOCATOR;

public class PastebinHomePageForm extends PastebinHomePage {

    @FindBy(id = "postform-text")
    private WebElement textPostform;

    @FindBy(id = "select2-postform-expiration-container")
    private WebElement expirationDropDownList;

    @FindBy(id = "select2-postform-format-container")
    private WebElement syntaxFormatDropDownList;

    @FindBy(id = "postform-name")
    private WebElement namePostform;

    @FindBy(xpath = "//button[@class='btn -big']")
    private WebElement createPasteButton;

    public PastebinHomePageForm(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePageForm fillTextForm(String text) {
        textPostform.sendKeys(text);
        return this;
    }

    public PastebinHomePageForm openExpirationDropDownList() {
        expirationDropDownList.click();
        return this;
    }

    public PastebinHomePageForm selectExpiration(String expiration) {
        selectDropDownListElement(BASE_LOCATOR, expiration);
        return this;
    }

    public PastebinHomePageForm openSyntaxHighlightingDropDownList() {
        syntaxFormatDropDownList.click();
        return this;
    }

    public PastebinHomePageForm selectSyntaxFormat(String syntaxFormat) {
        selectDropDownListElement(BASE_LOCATOR, syntaxFormat);
        return this;
    }

    public PastebinHomePageForm insertPasteName(String name) {
        namePostform.sendKeys(name);
        return this;
    }

    public PastebinHomePageForm createNewPaste() {
        createPasteButton.click();
        return this;
    }
}