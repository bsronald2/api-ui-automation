package com.auto.api.methods.auth

import com.auto.api.client.APICall
import com.auto.entities.User
import com.auto.entities.Authentication
import io.restassured.response.Response
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class AuthTodoLy extends APICall {

    private User user
    private String endpoint
    private Authentication auth
    private final static Logger logger = LogManager.getLogger(AuthTodoLy.class)

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

    @Override
    protected Tuple2<?, Response> call(String methodName, Map requestParams) {
        return null
    }
}
