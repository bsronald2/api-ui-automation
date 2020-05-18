package com.auto.api.client.rest

import com.auto.utils.Constants
import com.auto.utils.files.Configuration

interface Request {

    public static final REQUEST_TYPE = Configuration.getConfigurationValue(Constants.REQUEST__TYPE)

}