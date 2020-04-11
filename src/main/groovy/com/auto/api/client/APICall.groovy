package com.auto.api.client

import com.auto.api.client.rest.RestAPIClient

abstract class APICall extends ClientInfo {

    protected IAPIClient client
    protected String format

    enum HTTP_METHODS {
        POST,
        GET,
        DELETE,
        PUT
    }

    APICall(String url) {
        client = new RestAPIClient(url)
    }

    protected Object request(String APIMethod, Map params) {
        client.request(APIMethod, params)
        return null
    }



}
