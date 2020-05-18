package com.auto.api.steps;

import com.auto.utils.EntityManager;
import com.auto.utils.cucumber.CucumberConstants;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

public class CommonSteps implements CucumberConstants {

    private EntityManager entityManager;
    private Response response;

    public CommonSteps(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.response = (Response) this.entityManager.getEntity(RESPONSE);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode);
    }
}
