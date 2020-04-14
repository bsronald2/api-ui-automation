package com.auto.api.client.rest

import com.auto.api.client.ClientInfo
import com.auto.api.client.IAPIClient
import io.restassured.http.ContentType
import io.restassured.path.json.JsonPath
import io.restassured.response.Response
import io.restassured.RestAssured
import static io.restassured.RestAssured.given


class RestAPIClient extends ClientInfo implements IAPIClient {

    private ContentType contentType
    private Response response
    private Map requestBody
    private String httpMethod
    private String endPoint

    public RestAPIClient(String url) {
        RestAssured.baseURI = url
        RestAssured.useRelaxedHTTPSValidation()

    }

    @Override
    Response request(String APIMethod, Map params) {
        init(APIMethod, params)

        if (APIMethod == "GET") {
            get()
        }

        return null

    }

    private void get() {

    }
//        response = RestAssured.given()
//                .auth()
//                .preemptive()
//                .basic(requestBody.userName as String, requestBody.password as String)
//                .when()
//                .get("/")
//
//        return response

//        println response.getContentType()
//        println response.getStatusCode()


//        println response.getContentType()
//        println response.getStatusCode()
//        println(response.body.asString())
//        println "----------------"
//        String token = jsonPath.get("TokenString") as String
//        println token
//        response = RestAssured.given()
//                  .header("Token", token)
////                .auth()
////                .preemptive()
////                .basic(requestBody.userName as String, requestBody.password as String)
//                .when()
//                .get("api/projects.json")
//        println response.getContentType()
//        println response.getStatusCode()
//        println(response.body.asString())


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
                .basic(requestBody.userName as String, requestBody.password as String)
                .when()
                .get(endPoint + ".${requestType}")

        return response
    }

    void init(String APIMethod, Map params) {
        httpMethod = params.httpMethod
        requestBody = params."${APIMethod}"
        endPoint = params.endPoint
    }
}
