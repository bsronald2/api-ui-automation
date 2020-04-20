package com.auto.api.methods.users

import com.auto.api.client.APICall
import com.auto.api.entities.user.UserRequest
import com.auto.api.entities.user.UserResponse
import io.restassured.response.Response

class UserMethods extends APICall {

    private UserResponse userResponse
    private String endpoint

    UserMethods() {
        super(envInfo.url)
        this.endpoint = "api/user"
    }

    public void createUser(UserRequest userRequest) {
        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: POST,
                createUser : userRequest.getFormat(requestType)
        ]

        // When
        Response response = client.request("createUser", requestParams)
        println("Response Header: ${response.getHeaders().toString()}")
        println "Response Body: ${response.body.asString()}"

        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse
        println(userResponse.asMap())
    }

    public Tuple2<UserResponse, Response> getUser() {

        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: GET,
                getUser : null
        ]

        // When
        Response response = client.request("getUser", requestParams)

        // Then
        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse

        return new Tuple2<>(userResponse, response)
    }
}
