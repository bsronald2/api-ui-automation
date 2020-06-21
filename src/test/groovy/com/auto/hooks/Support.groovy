package com.auto.hooks

import com.auto.ui.browser.DriverManager
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


final class Support {

    private final static Logger logger = LogManager.getLogger(Support.class)

    private Support() {
        // could not initialize
    }

    public static void cleanUIEnvironment() {
        // After execution
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                DriverManager.getInstance().getDriver().close();
                logger.info("Close Web Browser.")
            }
        })
        Runtime.getName()
    }
}
