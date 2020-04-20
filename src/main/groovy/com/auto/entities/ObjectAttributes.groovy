package com.auto.entities

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.ObjectMapper

abstract class ObjectAttributes {


    /**
     * This method return class field values as map
     * @return map for instance attribute:top_akt, value:yes]
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
        this.class.declaredFields.findAll { (!it.synthetic && (this."$it.name" != null))  }.collectEntries {
            [ (it.name):this."$it.name" ]
        }
    }

    /**
     * This method return all attributes as Json string.
     *
     * @return attributes as String
     */
    public String asJsonString() {
        return new ObjectMapper().writeValueAsString(asMap());
    }

    public String getFormat(String format) {
        switch (format) {
            case "json":
                return asJsonString()
            case "xml":
                return ""

        }
        return null
    }
}
