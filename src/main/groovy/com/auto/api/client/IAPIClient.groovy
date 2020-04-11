package com.auto.api.client

import io.restassured.response.Response

interface IAPIClient {

    Response request(String method, Map params)
    Response requestAuth(String method, Map params)

}