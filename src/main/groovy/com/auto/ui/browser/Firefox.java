package com.auto.ui.browser;


import com.auto.utils.Constants;
import com.auto.utils.EnvironmentChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * This class initialize the Firefox Selenium Web Driver.
 */
public class Firefox implements EnvironmentDriver {

    private static final String WEB_DRIVER_PATH_WINDOWS = "drivers/geckodriver.exe";
    private static final String WEB_DRIVER_PATH_LINUX = "drivers/geckodriver";
    private static final String WEB_DRIVER_KEY = "webdriver.gecko.driver";
    private final Logger log = LogManager.getLogger(Firefox.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver initDriver() {
        final String webDriverPath = getWebDriverPath();
        System.setProperty(WEB_DRIVER_KEY, webDriverPath);
        return new FirefoxDriver();
    }


    @Override
    public String getWebDriverPath() {
        final String osName = EnvironmentChecker.getInstance().getOsName();
        if (osName.equals(Constants.WINDOWS_OS)) {
            return WEB_DRIVER_PATH_WINDOWS;
        } else if (osName.equals(Constants.LINUX_OS)) {
            return WEB_DRIVER_PATH_LINUX;
        } else {
            log.info("Web driver path was not found for " + osName);
            throw new RuntimeException("Environment not supported");
        }
    }
}
