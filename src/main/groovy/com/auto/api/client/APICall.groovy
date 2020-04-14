package com.auto.api.client

import com.auto.api.client.rest.RestAPIClient
import com.auto.entities.Authentication
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper

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

    /**
     * Parse response body (xml or json) to an Object.
     *
     * @param responseBody as String
     * @param aClass class type
     * @return response body as object
     */
    protected Object parseOToObject(String responseBody, Class<?> aClass) {

        switch (requestType) {
            case "json":
                return new ObjectMapper().readValue(responseBody, aClass)
            case "xml":
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(responseBody, aClass)
        }

        return null
    }



}
