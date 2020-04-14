package com.auto.api.methods.auth

import com.auto.api.client.APICall
import com.auto.entities.User
import com.auto.entities.Authentication
import io.restassured.response.Response
import org.apache.http.HttpStatus

class AuthTodoLy extends APICall {

    private User user
    private String endpoint
    private Authentication auth


    AuthTodoLy() {
        super(envInfo.url)
        this.user = envInfo.user
        this.endpoint = "${envInfo.url}/api/authentication/token"
    }

    public Authentication getAuth() {
        return auth
    }

    /**
     * This method request token authentication.
     * and save as entity
     */
    public void basicAuth() {
        // Given
        Map requestParams = [
                endPoint: "/api/authentication/token",
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

        // Parse response to object
        Authentication auth = parseOToObject(response.body.asString(), Authentication.class) as Authentication

        envInfo.setAPIAuth(auth)
    }

    public void setAuth(Authentication auth) {
        this.auth = auth
    }
}
