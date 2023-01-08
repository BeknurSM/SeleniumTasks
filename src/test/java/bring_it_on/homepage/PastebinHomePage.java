package bring_it_on.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static bring_it_on.util.LocatorCreator.createXPath;
import static bring_it_on.util.Waitings.waitForElementToBeClickable;

public class PastebinHomePage{
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    private static final String HOME_PAGE_URL = "https://pastebin.com";

    protected WebDriver driver;

    public PastebinHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePageForm openPage() {
        driver.get(HOME_PAGE_URL);
        return new PastebinHomePageForm(driver);
    }
    protected void selectDropDownListElement(String locator, String instanceValue) {
        WebElement element = driver.findElement(By.xpath(createXPath(locator, instanceValue)));
        waitForElementToBeClickable(element, driver);
        element.click();
    }
    protected WebDriverWait getNewWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
    }
    protected WebElement waitPresenceOfElementLocated(By locator) {
        return getNewWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
