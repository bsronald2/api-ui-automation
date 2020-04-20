package com.auto.api.steps;

import com.auto.api.entities.user.UserRequest;
import com.auto.api.entities.user.UserResponse;
import com.auto.api.methods.users.UserMethods;
import com.auto.utils.EntityManager;
import com.auto.utils.cucumber.CucumberConstants;
import groovy.lang.Tuple2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UserSteps2 implements CucumberConstants {

    private EntityManager entityManager;
    private Response response;
    private UserResponse userResponse;

    public UserSteps2(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @When("^I create a new user$")
    public void createNewUser(DataTable table) {
        Map<String, UserRequest> users = table.asMap(String.class, UserRequest.class);
        UserMethods userMethods = new UserMethods();
        users.forEach((k, v) -> {
            userMethods.createUser(v);
            System.out.println(v.asMap());

        });
    }

    @When("^I delete the next users$")
    public void deleteUser(DataTable table) {
        Map<String, UserRequest> users = table.asMap(String.class, UserRequest.class);
        UserMethods userMethods = new UserMethods();
    }

    @When("^I get \"([^\"]*)\" user$")
    public void selectUser(String user) {
        UserMethods userMethods = new UserMethods();
        Tuple2<UserResponse, Response> tuple2 = userMethods.getUser();
        this.response = tuple2.getSecond();
        this.entityManager.put(RESPONSE, tuple2.getSecond());
        this.entityManager.put(user, tuple2.getFirst());
    }

    @And("{string} should have the following key-values")
    public void shouldHaveTheFollowingKeyValues(String user, DataTable table) {
        List<UserResponse> userResponseList = table.asList(UserResponse.class);
        UserResponse actualUser = (UserResponse) this.entityManager.getEntity(user);
        for(UserResponse expectedUser : userResponseList) {
            Assert.assertEquals("Users are not equals", expectedUser, actualUser);
        }
    }
}
