package com.auto.api.entities.user

import com.auto.entities.ObjectAttributes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest extends ObjectAttributes {

    @JsonProperty("Email")
    String email

    @JsonProperty("FullName")
    String fullName

    @JsonProperty("Password")
    String password

}
