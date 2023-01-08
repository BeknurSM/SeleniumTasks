package i_can_win.test;

import i_can_win.homepage.PastebinHomePage;
import i_can_win.homepage.PastebinHomePageForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PastebinTest {

    private static final String EXPIRATION = "10 Minutes";
    private static final String TEXT = "Hello from WebDriver";
    private static final String NAME = "helloweb";

    private WebDriver driver;

    @BeforeClass(enabled = false, description = "Create driver and open max size window")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test (enabled = false, description = "Create new paste on Pastebin")
    public void isPastebinTitleCorrect() {
        PastebinHomePageForm pastebinHomePageForm = new PastebinHomePage(driver)
                .openPage()
                .fillTextForm(TEXT)
                .openExpirationDropDownList()
                .insertExpiration(EXPIRATION)
                .insertPasteName(NAME)
                .createNewPaste();
    }

//    @AfterClass(alwaysRun = true, description = "Close browser after tests")
//    public void browserShutDown() {
//        driver.quit();
//        driver = null;
//    }
}