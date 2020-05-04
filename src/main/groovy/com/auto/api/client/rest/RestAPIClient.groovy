package com.auto.api.client.rest

import com.auto.api.client.APICall
import com.auto.api.client.ClientInfo
import com.auto.api.client.IAPIClient
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.RestAssured
import io.restassured.specification.RequestSpecification

import static io.restassured.RestAssured.given


class RestAPIClient extends ClientInfo implements IAPIClient, HttpMethods {

    private ContentType contentType
    private Response response
    private String requestBody
    private String httpMethod
    private String endPoint
    private String token
    private Map auth
    private RequestSpecification request

    public RestAPIClient(String url) {
        RestAssured.baseURI = url
        RestAssured.useRelaxedHTTPSValidation()
        this.token = envInfo.api.authentication.tokenString

    }

    @Override
    Response request(String APIMethod, Map params) {
        init(APIMethod, params)
        switch (this.httpMethod) {
            case GET:
                return get()
            case POST:
                return post()
            case PUT:
                return put()
            case DELETE:
                return delete()
        }

        return null
    }

    private Response delete() {
        response = request
                .when()
                .delete("${this.endPoint}.${requestType}")

        return response
    }

    private Response post() {
        response = request
                  .body(requestBody)
                  .when()
                  .post("${this.endPoint}.${requestType}")

        return response
    }

    private Response put() {
        response = request
                .body(requestBody)
                .when()
                .put("${this.endPoint}.${requestType}")

        return response
    }

    private Response get() {
        response = request
                .when()
                .get("${this.endPoint}.${requestType}")

        return response
    }

    /**
     * This method request token authentication.
     *
     * @param APIMethod i.e. basicAuth
     * @param params request params as Map
     * @return request Response
     */
    @Override
    Response requestAuth(String APIMethod, Map params) {
        init(APIMethod, params)
        response = request
                .when()
                .get(endPoint + ".${requestType}")

        return response
    }

    void init(String APIMethod, Map params) {
        httpMethod = params.httpMethod
        requestBody = params."${APIMethod}"
        endPoint = params.endPoint
        setRequest(params)
    }

    /**
     * Set request authentication.
     *
     * @param params i.e. [header: [username: xxxx, password: yyyy]]
     */
    void setRequest(Map params) {
        if (params.header != null) {
            auth = params.header.auth
            request = given()
                    .auth()
                    .preemptive()
                    .basic(auth.userName as String, auth.password as String)
        } else {
            println "--------> T${this.token}"
            request = given()
                    .header("Token", this.token)
                    .log().method()
                    .log().body()
        }
    }
}
