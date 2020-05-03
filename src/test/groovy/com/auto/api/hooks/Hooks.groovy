package com.auto.api.hooks

import com.auto.api.methods.auth.AuthTodoLy
import com.auto.api.methods.users.UserMethods
import com.auto.utils.CredentialHandler
import com.auto.utils.EntityManager
import io.cucumber.core.api.Scenario
import io.cucumber.java.After
import io.cucumber.java.Before



public class Hooks {
    public static int SET_UP_ENV_FLAG = 1
    private EntityManager entityManager
    public Hooks(EntityManager entityManager) {
        this.entityManager = entityManager
    }

    @Before
    public void setup(Scenario scenario) {
        if(SET_UP_ENV_FLAG) { // JUST ONCE
            AuthTodoLy authTodoLy = new AuthTodoLy()
            authTodoLy.basicAuth()
            SET_UP_ENV_FLAG = 0;
        }
    }

//    @After
//    public void tearDown() {
//
//    }

    @After("@deleteUser and not @NotDeleteUser")
    public void doSomethingAfter(Scenario scenario){
        Map objects = this.entityManager.filterByObjectType("_AUTH")

        UserMethods userMethods = new UserMethods();
        objects.each {k,v ->
            userMethods.deleteUser(v as Map)
        }
    }
}
