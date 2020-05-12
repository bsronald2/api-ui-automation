package com.auto.api.methods.projects;

import com.auto.api.client.APICall
import com.auto.api.entities.projects.AllProjectResponse
import com.auto.api.entities.projects.ProjectRequest
import com.auto.api.entities.projects.ProjectResponse
import com.auto.api.entities.user.UserResponse;
import io.restassured.response.Response
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger;


public class ProjectsMethods extends APICall {
    private final static Logger logger = LogManager.getLogger(ProjectsMethods.class)

    public ProjectsMethods() {
        super(envInfo.getUrl());
        this.endpoint = "api/projects"
    }

    @Override
    protected Tuple2<?, Response> call(String methodName, Map requestParams) {
        // When
        Response response = client.request(methodName, requestParams)

        // Then
        ProjectResponse projectResponse = parseOToObject(response.body.asString(), ProjectResponse.class) as ProjectResponse

        logger.info("Status Code: ${response.statusCode}")
        logger.info("Response Body:${response.body.asString()}")

        return new Tuple2<>(projectResponse, response)
    }

    public Tuple2<List<ProjectResponse>, Response> getAllProject() {

        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: GET,
                getProject : null
        ]

        // When
        Response response = client.request("getProject", requestParams)

        // Then
        List<ProjectResponse> projectResponse = parseToList(response.body.asString(), ProjectResponse.class) as List<ProjectResponse>

        logger.info("Status Code: ${response.statusCode}")
        logger.info("Response Body:${response.body.asString()}")

        return new Tuple2<>(projectResponse, response)
    }

    public Tuple2<List<ProjectResponse>, Response> getProject(long projectId) {
        // Given
        Map requestParams = [
                endPoint: "${this.endpoint}/$projectId",
                httpMethod: GET,
                getProject : null
        ]

        return call("getProject", requestParams)
    }

    public Tuple2<ProjectResponse, Response> createProject(ProjectRequest projectRequest) {

        // Given
        Map requestParams = [
                endPoint: this.endpoint,
                httpMethod: POST,
                postProject : projectRequest.getFormat(requestType, false)
        ]

        return call("postProject", requestParams)
    }

    public Tuple2<ProjectResponse, Response> deleteProject(long id) {
        // Given
        Map requestParams = [
                endPoint: "${this.endpoint}/$id",
                httpMethod: DELETE,
                deleteProject : null
        ]

        return call("deleteProject", requestParams)
    }

    Tuple2<ProjectResponse, Response> updateProject(long id, ProjectRequest projectRequest) {
        // Given
        Map requestParams = [
                endPoint: "${this.endpoint}/$id",
                httpMethod: PUT,
                updateProject : projectRequest.getFormat(requestType, false)
        ]

        return call("updateProject", requestParams)
    }
}
