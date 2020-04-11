package com.auto.utils


import com.auto.entities.API
import com.auto.entities.User
import com.auto.entities.Authentication

class EnvInfo {

    API api
    User user
    int version
    String id
    String url


    public void loadInitParams() {
        user.setUserName(System.getProperty("userName"))
        user.setPassword(System.getProperty("password"))
    }

    public setAPIAuth(Map auth) {
        api.authentication.tokenString = auth.TokenString
        api.authentication.expirationTime = auth.ExpirationTime
        api.authentication.userMail = auth.UserEmail
    }

    public void setAuth(Authentication auth) {
        api.authentication = auth
    }
}
