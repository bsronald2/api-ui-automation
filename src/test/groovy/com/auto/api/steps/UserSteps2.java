package com.auto.api.steps;

import com.auto.api.entities.user.UserRequest;
import com.auto.api.entities.user.UserResponse;
import com.auto.api.methods.users.UserMethods;
import com.auto.utils.EntityManager;
import com.auto.utils.cucumber.CucumberConstants;
import groovy.lang.Tuple2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class UserSteps2 implements CucumberConstants {

    private EntityManager entityManager;
    private Response response;
    private UserResponse userResponse;
    private Map<String, String> userCredentials;
    private UserMethods userMethods;

    public UserSteps2(EntityManager entityManager) {
        this.entityManager = entityManager;

    }


    @When("^I create a new user$")
    public void createNewUser(DataTable table) {
        Map<String, UserRequest> users = table.asMap(String.class, UserRequest.class);
        userMethods = new UserMethods();
        users.forEach((k, v) -> {
            userMethods.createUser(v);
            System.out.println(v.asMap());

        });
    }

    @When("^I delete the next users$")
    public void deleteUser(List<String> users) {
        for (String user : users) {
            userCredentials = (Map<String, String>) this.entityManager.getEntity(user + "_AUTH");
            Tuple2<UserResponse, Response> tuple2 = userMethods.deleteUser(userCredentials);
            this.response = tuple2.getSecond();
            this.entityManager.put(RESPONSE, tuple2.getSecond());
            this.entityManager.put(user, tuple2.getFirst());
        }

    }

    @When("^I get \"([^\"]*)\" user$")
    public void selectUser(String user) {
        userCredentials = (Map<String, String>) this.entityManager.getEntity(user + "_AUTH");
        Tuple2<UserResponse, Response> tuple2 = userCredentials == null?
                userMethods.getUser() : userMethods.getUser(userCredentials);
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

    @Given("I log in with the following user")
    public void iLogInWithTheFollowingUser(DataTable table) {
        Map<String, UserRequest> users = table.asMap(String.class, UserRequest.class);
        userMethods = new UserMethods();
        for (Map.Entry<String, UserRequest> entry : users.entrySet()) {
            Tuple2<UserResponse, Response> tuple2 = userMethods.createUser(entry.getValue());
            userCredentials = entry.getValue().asMap();
            this.entityManager.put(entry.getKey(), tuple2.getFirst());
            this.entityManager.put(entry.getKey() + "_AUTH", userCredentials);
        }
    }
}
