package bring_it_on.util;

public class LocatorCreator {

    public static final String BASE_LOCATOR = "//li[text()='%s']";

    public static String createXPath(String baseLocator, String instanceValue) {
        return String.format(baseLocator, instanceValue);
    }
}