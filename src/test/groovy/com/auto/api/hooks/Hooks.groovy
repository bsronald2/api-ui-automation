package com.auto.api.hooks

import com.auto.entities.EnvInfo
import com.auto.utils.Constants
import com.auto.utils.files.YamlFile
import io.cucumber.core.api.Scenario
import io.cucumber.java.Before
import org.junit.After


class Hooks {
    public static int SET_UP_ENV_FLAG = 0

    @Before
    public static void setup(Scenario scenario) {
        if(SET_UP_ENV_FLAG == 0) {
            // Read credentials
            YamlFile reader = new YamlFile()
            EnvInfo envInfo = (EnvInfo) reader.loadYamlFileAsObject(EnvInfo.class, Constants.ENV_INFO_PATH)
            envInfo.setInit()
            SET_UP_ENV_FLAG = 1;
        }
    }

    @After
    public static void tearDown() {

    }
}
