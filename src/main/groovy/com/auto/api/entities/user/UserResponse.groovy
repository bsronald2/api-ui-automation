package com.auto.api.entities.user

import com.auto.entities.ObjectAttributes

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import groovy.transform.Immutable

@JsonIgnoreProperties(ignoreUnknown = true)
//@Immutable ->  override equals and hashcode
@JacksonXmlRootElement(localName = "UserObject")
class UserResponse extends ObjectAttributes {

    @JsonProperty("Id")
    int id

    @JsonProperty("Email")
    String email

    @JsonProperty("FullName")
    String fullName

    @JsonProperty("DefaultProjectId")
    int defaultProjectId

    @JsonProperty("EditDueDateMoreExpanded")
    boolean editDueDateMoreExpanded

    @JsonProperty("ListSortType")
    int listSortType

    @JsonProperty("FirstDayOfWeek")
    short firstDayOfWeek

    @JsonProperty("NewTaskDueDate")
    int newTaskDueDate

    @JsonProperty("TimeZone")
    int timeZone

    @JsonProperty("IsProUser")
    boolean isProUser

    @JsonProperty("AddItemMoreExpanded")
    boolean addItemMoreExpanded

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof UserResponse)) return false

        UserResponse that = (UserResponse) o

        if (addItemMoreExpanded != that.addItemMoreExpanded) return false
        if (editDueDateMoreExpanded != that.editDueDateMoreExpanded) return false
        if (firstDayOfWeek != that.firstDayOfWeek) return false
        if (isProUser != that.isProUser) return false
        if (listSortType != that.listSortType) return false
        if (newTaskDueDate != that.newTaskDueDate) return false
        if (timeZone != that.timeZone) return false
        if (email != that.email) return false
        if (fullName != that.fullName) return false

        return true
    }

    int hashCode() {
        int result = 0
        result = 31 * result + email.hashCode()
        result = 31 * result + fullName.hashCode()
        result = 31 * result + (editDueDateMoreExpanded ? 1 : 0)
        result = 31 * result + listSortType
        result = 31 * result + (int) firstDayOfWeek
        result = 31 * result + newTaskDueDate
        result = 31 * result + timeZone
        result = 31 * result + (isProUser ? 1 : 0)
        result = 31 * result + (addItemMoreExpanded ? 1 : 0)

        return result
    }

    public String toString() {
        return this.asMap().toString()
    }
}
