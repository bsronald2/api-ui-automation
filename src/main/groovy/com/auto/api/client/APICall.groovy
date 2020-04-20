package com.auto.api.client

import com.auto.api.client.rest.Format
import com.auto.api.client.rest.HttpMethods
import com.auto.api.client.rest.RestAPIClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.apache.http.HttpStatus

abstract class APICall extends ClientInfo implements HttpStatus, HttpMethods, Format {

    protected IAPIClient client
    protected String format


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
            case JSON:
                return new ObjectMapper().readValue(responseBody, aClass)
            case XML:
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(responseBody, aClass)
        }

        return null
    }



}