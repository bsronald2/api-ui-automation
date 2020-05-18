package com.auto.utils


import com.auto.entities.API
import com.auto.entities.UI
import com.auto.entities.User
import com.auto.entities.Authentication

class EnvInfo {

    API api
    User user
    int version
    String id
    String url
    UI ui


    public void loadInitParams() {
        user.setUserName(System.getProperty("userName"))
        user.setPassword(System.getProperty("password"))
    }

    public setAPIAuth(Authentication auth) {
        api.authentication = auth
    }

    public void setAuth(Authentication auth) {
        api.authentication = auth
    }
}
