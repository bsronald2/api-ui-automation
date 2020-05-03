package com.auto.api.methods.auth

<<<<<<< HEAD
import com.auto.entities.EnvInfo
import com.auto.entities.User
import com.auto.entities.api.Authentication
=======
import com.auto.api.client.APICall
import com.auto.entities.User
import com.auto.entities.Authentication
import io.restassured.response.Response
>>>>>>> 95544d204a737afb8d545775fd4882448db2947d

class AuthTodoLy extends APICall {

    private User user
    private String endpoint
    private Authentication auth

<<<<<<< HEAD
    AuthTodoLy(EnvInfo envInfo) {
        this.user = envInfo.user
        this.endpoint = "${envInfo.api.url}/authentication/token.json"
    }

    public Authentication getAuth() {
        return auth

    }

    public void requestAuthToken() {

=======

    AuthTodoLy() {
        super(envInfo.url)
        this.user = envInfo.user
        this.endpoint = "/api/authentication/token"
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
                endPoint: this.endpoint,
                httpMethod: GET,
                header: [
                        auth: [
                                userName: this.user.getUserName(),
                                password: this.user.getPassword()
                        ]
                ],
                basicAuth : ""
        ]

        // When
        Response response = client.requestAuth("basicAuth", requestParams)

        // Then
        response.then()
                .assertThat()
                .statusCode(SC_OK)

        // Parse response to object
        Authentication auth = parseOToObject(response.body.asString(), Authentication.class) as Authentication

        envInfo.setAPIAuth(auth)
    }

    public void setAuth(Authentication auth) {
        this.auth = auth
    }
>>>>>>> 95544d204a737afb8d545775fd4882448db2947d

    @Override
    protected Tuple2<?, Response> call(String methodName, Map requestParams) {
        return null
    }
}
