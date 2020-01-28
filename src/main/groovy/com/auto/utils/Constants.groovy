package com.auto.utils

import java.nio.file.Path
import java.nio.file.Paths

class Constants {


    // Absolute Paths
    public static Path dir = Paths.get('src')
    public static final UTILS_PATH = dir.toAbsolutePath().toString()

    /* Utils files paths */
    public static final String ENV_NAME = "ENV_NAME"
    public static final String CONFIG_PROP_PATH = "${UTILS_PATH}/main/resources/config.properties"
    public static final String ENV_INFO_PATH = "${UTILS_PATH}/main/resources/envInfo.yaml"
    //home/ronald/IdeaProjects/automation_demo/src/main/resources/envInfo.yaml
}
