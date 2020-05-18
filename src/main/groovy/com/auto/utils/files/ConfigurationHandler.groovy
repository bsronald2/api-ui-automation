package com.auto.utils.files

import com.auto.utils.Constants

abstract class ConfigurationHandler {

    protected static String requestType = Configuration.getConfigurationValue(Constants.REQUEST__TYPE)
}
