package com.auto.api.entities.projects

import com.auto.entities.ObjectAttributes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement

@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "ProjectObject")
class AllProjectResponse extends ObjectAttributes {
    @JsonProperty("Id")
    long id

    @JsonProperty("Content")
    String content

    @JsonProperty("ItemsCount")
    int itemsCount

    @JsonProperty("Icon")
    int icon

    @JsonProperty("ItemType")
    int itemType

    @JsonProperty("ParentId")
    String parentId

    @JsonProperty("Collapsed")
    boolean collapsed

    @JsonProperty("ItemOrder")
    int itemOrder

    @JsonProperty("Children")
    List<ProjectResponse> children

    @JsonProperty("IsProjectShared")
    boolean isProjectShared

    @JsonProperty("IsShareApproved")
    boolean isShareApproved

    @JsonProperty("IsOwnProject")
    boolean isOwnProject

    @JsonProperty("Deleted")
    boolean deleted

    boolean equals(o) {
        if (this.is(o)) return true
        if (!(o instanceof AllProjectResponse)) return false

        AllProjectResponse that = (AllProjectResponse) o

        if (collapsed != that.collapsed) return false
        if (deleted != that.deleted) return false
        if (icon != that.icon) return false
        if (isOwnProject != that.isOwnProject) return false
        if (isProjectShared != that.isProjectShared) return false
        if (isShareApproved != that.isShareApproved) return false
        if (itemOrder != that.itemOrder) return false
        if (itemType != that.itemType) return false
        if (itemsCount != that.itemsCount) return false
        if (content != that.content) return false
        if (parentId != that.parentId) return false

        return true
    }

    int hashCode() {
        int result
        result = (content != null ? content.hashCode() : 0)
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0)
        result = 31 * result + itemsCount
        result = 31 * result + icon
        result = 31 * result + itemType
        result = 31 * result + (collapsed ? 1 : 0)
        result = 31 * result + itemOrder
        result = 31 * result + (isProjectShared ? 1 : 0)
        result = 31 * result + (isShareApproved ? 1 : 0)
        result = 31 * result + (isOwnProject ? 1 : 0)
        result = 31 * result + (deleted ? 1 : 0)
        return result
    }
}
