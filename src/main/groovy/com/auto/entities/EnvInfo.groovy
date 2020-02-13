package com.auto.entities

import com.auto.api.methods.auth.AuthTodoLy

class EnvInfo {

    API api
    User user
    int version
    String id


    public void setInit() {
        user.setUserName(System.getProperty("userName"))
        user.setPassword(System.getProperty("password"))
        AuthTodoLy authTodoLy = new AuthTodoLy(this)
        authTodoLy.requestAuthToken()
        api.setAuthentication(authTodoLy.getAuth())
    }
}
