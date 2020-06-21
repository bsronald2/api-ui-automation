package com.auto.api.client

import com.auto.api.client.rest.Request
import com.auto.utils.Constants
import com.auto.utils.EnvironmentHandler
import com.auto.utils.EnvInfo

interface ClientInfo  {

    public static final EnvInfo envInfo = new EnvironmentHandler(Constants.ENV_INFO_PATH).getEnvInfo()
}
