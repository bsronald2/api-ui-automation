package com.auto.api.client

import com.auto.entities.API
import com.auto.entities.User
import com.auto.utils.Constants
import com.auto.utils.CredentialHandler
import com.auto.utils.EnvInfo

abstract class ClientInfo implements IClientInfo {

    protected static EnvInfo envInfo = new CredentialHandler(Constants.ENV_INFO_PATH).getEnvInfo()


}
