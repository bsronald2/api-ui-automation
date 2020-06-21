package com.auto.ui.pages.common

import com.auto.ui.browser.DriverManager
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver

class UICommonMethods {

    private static WebDriver driver = DriverManager.getInstance().getDriver()
    private static final Logger log = LogManager.getLogger(UICommonMethods.class)

    private UICommonMethods() {}


    /**
     * This method verifies if it is possible to find the WebElement.
     *
     * @param by element within document
     * @return true if WebElement was loaded otherwise return false
     */
    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * The driver wait to find a element.
     *
     * @param maxCount number of times to wait
     * @param by       to search
     * @return true or false
     */
    public static boolean waitElementIsPresent(int maxCount, By by) {
        boolean result = false;
        int count = 1;
        log.info("Wait Element is present ->" + by.toString());
        while (!result && count <= maxCount) {
            result = isElementPresent(by);
            count++;
        }
        return result;
    }


}
