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

    /*Configuration File */
    public static final String EXEC__TYPE = "EXEC_TYPE"
    public static final String REQUEST__TYPE = "REQUEST_TYPE"
    public static final String PREFIX = "PREFIX"
    public static final String TAGS = "TAGS"

    /* ASCII CODE*/
    public static final int CODE_ASCII_A = 65
}
