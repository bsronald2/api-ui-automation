package com.auto.api.entities.projects

import com.auto.entities.ObjectAttributes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JacksonXmlRootElement(localName = "ProjectObject")
@JsonIgnoreProperties(ignoreUnknown = true)
class ProjectRequest extends ObjectAttributes {

    @JsonProperty("Content")
    String content

    @JsonProperty("Icon")
    int icon

    @JsonProperty("ItemOrder")
    int itemOrder
}
