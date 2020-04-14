package com.auto.api.client

import com.auto.entities.API
import com.auto.entities.User
import com.auto.utils.Constants
import com.auto.utils.CredentialHandler
import com.auto.utils.EnvInfo
import com.auto.utils.files.Configuration

abstract class ClientInfo implements IClientInfo {

    protected static EnvInfo envInfo = new CredentialHandler(Constants.ENV_INFO_PATH).getEnvInfo()
    protected static String requestType = Configuration.getConfigurationValue(Constants.REQUEST__TYPE)


}
