package com.auto.api.hooks

import com.auto.api.methods.auth.AuthTodoLy
import com.auto.utils.CredentialHandler


import io.cucumber.core.api.Scenario
import io.cucumber.java.Before
import org.junit.After


public class Hooks {
    public static int SET_UP_ENV_FLAG = 1

    @Before
    public void setup(Scenario scenario) {
        println "-------" + SET_UP_ENV_FLAG
        if(SET_UP_ENV_FLAG) { // JUST ONCE
            AuthTodoLy authTodoLy = new AuthTodoLy()
            authTodoLy.basicAuth()
            SET_UP_ENV_FLAG = 0;
        }
    }

    @After
    public void tearDown() {

    }
}
