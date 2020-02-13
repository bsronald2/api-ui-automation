package com.auto.api.methods.auth

import com.auto.entities.EnvInfo
import com.auto.entities.User
import com.auto.entities.api.Authentication

class AuthTodoLy {

    private User user
    private String endpoint
    private Authentication auth

    AuthTodoLy(EnvInfo envInfo) {
        this.user = envInfo.user
        this.endpoint = "${envInfo.api.url}/authentication/token.json"
    }

    public Authentication getAuth() {
        return auth

    }

    public void requestAuthToken() {


    }
}
