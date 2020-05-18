package com.auto.ui.browser;

import com.auto.utils.Constants;
import com.auto.utils.EnvInfo;
import com.auto.utils.EnvironmentHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * this class is to provide basic methods for manage the Selenium driver,
 * and initialize the logger main resources path.
 */
public final class DriverManager {

    private static final EnvInfo ENVIRONMENT = new EnvironmentHandler(Constants.ENV_INFO_PATH).getEnvInfo();
    public static final int WAIT_TIME_OUT = 30;

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * This method is in charge to initialize the DriverManager.
     */
    private DriverManager() {
        final String baseUrl = ENVIRONMENT.getUrl();
        final int timeout = ENVIRONMENT.getUi().getTimeout();
        final Browser browser = Browser.valueOf(ENVIRONMENT.getUi().getBrowser().toUpperCase());
        driver = DriverFactory.getDriver(browser).initDriver();
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIME_OUT);
        driver.get(baseUrl);
    }

    /**
     * This method Instance the instance if this does not exist.
     *
     * @return a instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Get the webDriver specification.
     *
     * @return webDriver Specification.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * This method obtains WebDriverWait.
     *
     * @return WebDriverWait.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
