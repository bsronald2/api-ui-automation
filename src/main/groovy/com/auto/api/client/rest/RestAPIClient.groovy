package com.auto.api.client.rest

import com.auto.api.client.APICall
import com.auto.api.client.ClientInfo
import com.auto.api.client.IAPIClient
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.RestAssured
import static io.restassured.RestAssured.given


class RestAPIClient extends ClientInfo implements IAPIClient, HttpMethods {

    private ContentType contentType
    private Response response
    private String requestBody
    private String httpMethod
    private String endPoint
    private String token
    private Map auth

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
                break
            case PUT:
                break
            case DELETE:
                break
        }

        return null

    }

    private Response post() {
        response = given()
                  .header("Token", this.token)
                  .log().method()
                  .log().body()
                      .body(requestBody)
                  .when()
                  .post("${this.endPoint}.${requestType}")

        return response
    }

    private Response get() {
        response = given()
                .header("Token", this.token)
                .log().method()
                .log().body()
                .log().uri()
                .when()
                .get("${this.endPoint}.${requestType}")
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
        response = given()
                .auth()
                .preemptive()
                .basic(auth.userName as String, auth.password as String)
                .when()
                .get(endPoint + ".${requestType}")

        return response
    }

    void init(String APIMethod, Map params) {
        httpMethod = params.httpMethod
        requestBody = params."${APIMethod}"
        endPoint = params.endPoint
        if (params.header != null) {
            auth = params.header.auth
        }

    }
}
