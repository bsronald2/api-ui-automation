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

    public Tuple2<UserResponse, Response> createUser(UserRequest userRequest) {
        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: POST,
                createUser : userRequest.getFormat(requestType)
        ]

        // When
        Response response = client.request("createUser", requestParams)

        //Then
        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse

        new Tuple2<>(userResponse, response)
    }

    public Tuple2<UserResponse, Response> getUser(Map credentials = null) {

        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: GET,
                getUser : null
        ]

        if (credentials) { // if credentials are null then use token
            requestParams << [ header: [
                    auth: [
                            userName: credentials.Email,
                            password: credentials.Password
                    ]
                ]
            ]
        }

        // When
        Response response = client.request("getUser", requestParams)

        // Then
        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse

        return new Tuple2<>(userResponse, response)
    }

    public Tuple2<UserResponse, Response> deleteUser(Map credentials = null) {
        // Given
        Map requestParams = [
                endPoint: "${this.endpoint}/0",
                httpMethod: DELETE,
                header: [
                        auth: [
                                userName: credentials.Email,
                                password: credentials.Password
                        ]
                ],
                deleteUser : null
        ]

        // When
        Response response = client.request("deleteUser", requestParams)

        // Then
        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse

        return new Tuple2<>(userResponse, response)
    }

    Tuple2<UserResponse, Response> putUser(UserRequest userRequest, Map credentials = null) {
        // Given
        Map requestParams = [
                endPoint: "${this.endpoint}/0",
                httpMethod: PUT,
                putUser : userRequest.getFormat(requestType, false)
        ]

        if (credentials) { // if credentials are null then use token
            requestParams << [ header: [
                    auth: [
                            userName: credentials.Email,
                            password: credentials.Password
                    ]
            ]
            ]
        }

        return call("putUser", requestParams)
    }

    @Override
    protected Tuple2<?, Response> call(String methodName, Map requestParams) {
        // When
        Response response = client.request(methodName, requestParams)

        // Then
        UserResponse userResponse = parseOToObject(response.body.asString(), UserResponse.class) as UserResponse

        return new Tuple2<>(userResponse, response)
    }
}
