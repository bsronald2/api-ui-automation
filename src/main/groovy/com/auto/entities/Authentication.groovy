package com.auto.entities

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
class Authentication {
    @JsonProperty("TokenString")
    String tokenString

    @JsonProperty("UserMail")
    String userMail

    @JsonProperty("ExpirationTime")
    String expirationTime

}
