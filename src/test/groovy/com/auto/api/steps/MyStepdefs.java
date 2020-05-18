package com.auto.api.steps;

import com.auto.utils.EnvironmentHandler;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyStepdefs implements En {

    private final static Logger logger = LogManager.getLogger(MyStepdefs.class);
    EnvironmentHandler environmentHandler;


    public MyStepdefs() {

        Given("^I print something \"([^\"]*)\"$", (String arg0) -> {
            System.out.println(arg0);
            System.out.println(logger.isInfoEnabled());

            logger.info("info! {}");
            logger.error("error! {}");
            logger.debug("debug! {}");
        });
    }
}
