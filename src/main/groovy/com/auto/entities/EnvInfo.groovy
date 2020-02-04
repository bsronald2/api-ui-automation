package com.auto.entities

import com.auto.api.methods.auth.AuthTodoLy

class EnvInfo {

    API api
    User user
    int version
    String id


    public void setInit() {
        println "Set INIT()--------------->"
        Properties p = System.getProperties();
        p.list(System.out);
        user.setUserName(System.getProperty("userName"))
        user.setPassword(System.getProperty("password"))
        AuthTodoLy authTodoLy = new AuthTodoLy(user)
        api.setToken("")

    }
}
