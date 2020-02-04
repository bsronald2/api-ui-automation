package com.auto.api.methods.auth

import com.auto.entities.User
import com.auto.entities.api.Token

class AuthTodoLy {

    private User user

    AuthTodoLy(User user) {
        this.user = user
        println(user.userName)
        println user.password
    }

    public Token getToken() {

    }
}
