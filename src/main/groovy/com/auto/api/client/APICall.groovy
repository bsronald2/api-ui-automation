package com.auto.api.client

import com.auto.api.client.rest.Format
import com.auto.api.client.rest.HttpMethods
import com.auto.api.client.rest.Request
import com.auto.api.client.rest.RestAPIClient
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import io.restassured.response.Response
import org.apache.http.HttpStatus

import java.lang.reflect.Constructor

abstract class APICall implements ClientInfo, HttpStatus, HttpMethods, Format, Request {

    protected IAPIClient client
    protected String format
    protected String endpoint


    APICall() {
        client = new RestAPIClient()
    }

    abstract protected Tuple2<?, Response> call(String methodName, Map requestParams)

    /**
     * Parse response body (xml or json) to an Object.
     *
     * @param responseBody as String
     * @param aClass class type
     * @return response body as object
     */
    protected Object parseOToObject(String responseBody, Class<?> aClass) {
        switch (REQUEST_TYPE) {
            case JSON:
                return new ObjectMapper().readValue(responseBody, aClass)
            case XML:
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(responseBody, aClass)
        }

        return null
    }

    protected List<?> parseToList(String responseBody, Class<?> aClass) {
        switch (REQUEST_TYPE) {
            case JSON:
                ObjectMapper mapper = new ObjectMapper()
                return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, aClass))
            case XML:
                XmlMapper xmlMapper = new XmlMapper();
                return xmlMapper.readValue(responseBody, xmlMapper.getTypeFactory().constructCollectionType(List.class, aClass))
        }
        return null

    }



}
