package com.auto.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

abstract class ObjectAttributes {
    private final static Logger logger = LogManager.getLogger(ObjectAttributes.class)

    /**
     * This method return class field values as map
     * @return map for instance attribute:deleted, value:true]
     */
    public Map asMap() {
        this.class.declaredFields.findAll { !it.synthetic && (it.isAnnotationPresent(JsonProperty.class)) }.collectEntries {
            [ (it.getAnnotation(JsonProperty.class).value()):this."$it.name" ]
        }
    }

    /**
     * Filter all fields that have null as value.
     *
     * @return fields as map without null objects
     */
    public Map asMapNonNull() {
        this.class.declaredFields.findAll { !it.synthetic && (it.isAnnotationPresent(JsonProperty.class)) && (this."$it.name" != null)}.collectEntries {
            [ (it.getAnnotation(JsonProperty.class).value()):this."$it.name" ]
        }
    }

    /**
     * This method return all attributes as Json string.
     *
     * @return attributes as String
     */
    public String asJsonString(boolean getNulls) {
        Map asMapValue = getNulls? asMap() : asMapNonNull()
        return new ObjectMapper().writeValueAsString(asMapValue);
    }

    public String asXMLString(boolean getNulls = true) {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(this)
    }

    public String getFormat(String format, boolean getNulls = true) {
        switch (format) {
            case "json":
                return asJsonString(getNulls)
            case "xml":
                return asXMLString()

        }
        logger.warn("Object was not parsed into $format")

        return null
    }

    public String toString() {
        return this.asMap().toString()
    }
}
