package com.auto.hooks

import com.auto.api.client.ClientInfo
import com.auto.api.methods.auth.AuthTodoLy
import com.auto.api.methods.projects.ProjectsMethods
import com.auto.api.methods.users.UserMethods
import com.auto.ui.pages.MainPage
import com.auto.ui.pages.login.SignInForm
import com.auto.utils.Constants
import com.auto.utils.EntityManager
import com.auto.utils.files.Configuration
import io.cucumber.core.api.Scenario
import io.cucumber.java.After
import io.cucumber.java.Before



public class Hooks implements ClientInfo {
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
            if (Configuration.getConfigurationValue(Constants.EXEC__TYPE).equalsIgnoreCase("ui")) {
                MainPage mainPage = SignInForm.loginAs(envInfo.getUser().getUserName(), envInfo.getUser().getPassword())
                this.entityManager.put(Constants.MAIN__PAGE, mainPage)
            }
        }
    }

    @After
    public void tearDown() {
        this.entityManager.clear()
    }

    @After("@deleteUser and not @NotDeleteUser")
    public void doSomethingAfter(Scenario scenario){
        Map objects = this.entityManager.filterByObjectType("_AUTH")

        UserMethods userMethods = new UserMethods();
        objects.each {k,v ->
            userMethods.deleteUser(v as Map)
        }
    }

    @After("@deleteProject")
    public void deleteProjectAfter(Scenario scenario) {
        Map objects = this.entityManager.filterByObjectType("Project")

        ProjectsMethods projectsMethods = new ProjectsMethods();
        objects.each { k, v ->
            projectsMethods.deleteProject(v.id)
        }
    }
}
