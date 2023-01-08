package i_can_win.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PastebinHomePage{

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
}