package bring_it_on.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waitings {

    public static final Duration BASE_WAIT_TIME = Duration.ofSeconds(10);

    public static void waitForElementToBeClickable(WebElement element, WebDriver driver){
        new WebDriverWait(driver, BASE_WAIT_TIME).until(ExpectedConditions.elementToBeClickable(element));
    }
}