package com.auto.api.methods.auth

import com.auto.api.client.APICall
import com.auto.entities.User
import com.auto.entities.Authentication
import io.restassured.response.Response
import org.apache.http.HttpStatus
import com.fasterxml.jackson.databind.ObjectMapper;

class AuthTodoLy extends APICall {

    private User user
    private String endpoint
    private Authentication auth


    AuthTodoLy() {
        super(envInfo.url)
        this.user = envInfo.user
        this.endpoint = "${envInfo.url}/api/authentication/token.json"
    }

    public Authentication getAuth() {
        return auth
    }

    public void getToken() {

    }

    public void basicAuth() {
        // Given
        Map requestParams = [
                endPoint: "/api/authentication/token.json",
                httpMethod: HTTP_METHODS.GET,
                basicAuth : [
                        userName: this.user.getUserName(),
                        password: this.user.getPassword()]
        ]

        // When
        Response response = client.requestAuth("basicAuth", requestParams)

        // Then
        response.then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)

        Map<String, String> map = new ObjectMapper().readValue(response.body.asString(), Map.class);
        envInfo.setAPIAuth(map)
    }


    public void setAuth(Authentication auth) {
        this.auth = auth
    }

    public void isAuthenticate() {

    }
}
