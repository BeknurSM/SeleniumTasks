package bring_it_on.test;

import bring_it_on.homepage.PastebinHomePage;
import bring_it_on.homepage.PastebinHomePageForm;
import bring_it_on.homepage.PastebinResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class PastebinTest {
    private static final String EXPIRATION_TIME = "10 Minutes";
    private static final String HIGHLIGHTING = "Bash";
    private static final String TEXT = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private static final String TITLE_NAME = "how to gain dominance among developers";


    private WebDriver driver;

    @BeforeClass(enabled = false, description = "Create driver and open max size window")
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(enabled = false, description = "Create new paste on Pastebin and filling the form")
    public void homePageTest() {
        PastebinHomePageForm pastebinHomePageForm = new PastebinHomePage(driver)
                .openPage()
                .fillTextForm(TEXT)
                .openSyntaxHighlightingDropDownList()
                .selectSyntaxFormat(HIGHLIGHTING)
                .openExpirationDropDownList()
                .selectExpiration(EXPIRATION_TIME)
                .insertPasteName(TITLE_NAME)
                .createNewPaste();
    }

    @Test (enabled = false, description = "Check for title name")
    public void pasteNameTitle() {
        Assert.assertEquals(PastebinResultPage.getTittleName(driver), TITLE_NAME, "Tittle name in published Pastebin is wrong");
    }

    @Test (enabled = false, description = "Check for syntax")
    public void highlightedSyntax() {
        Assert.assertEquals(PastebinResultPage.getHighlightedSyntax(driver), HIGHLIGHTING, "Highlighted syntax is wrong");
    }

//    @Test (enabled = false, description = "Compare text to be not different from inserted")
//    public void textContents() {
//        Assert.assertEquals(pastebinResultPage.clickRawButton().getTextContent(), TEXT, "Content text is different from expected");
//    }

    @AfterClass(enabled = false, description = "Close browser after tests")
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}