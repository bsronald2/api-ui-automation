package com.auto.api.steps;

import com.auto.api.entities.projects.ProjectRequest;
import com.auto.api.entities.projects.ProjectResponse;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import com.auto.api.methods.projects.ProjectsMethods;
import com.auto.utils.EntityManager;
import com.auto.utils.MapUtils;
import com.auto.utils.cucumber.CucumberConstants;
import groovy.lang.Tuple2;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

public class ProjectsSteps implements CucumberConstants {

    private EntityManager entityManager;
    private ProjectsMethods projectsMethod;
    private Response response;

    public ProjectsSteps(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.projectsMethod = new ProjectsMethods();

    }

    @When("I get {string} projects")
    public void iGetProjects(String project) {
        Tuple2<List<ProjectResponse>, Response> tuple2;
        if (project.trim().equals("all")) {
            tuple2 = projectsMethod.getAllProject();
            Map<String, ?> mapped = MapUtils.listToMap("Project", tuple2.getFirst());
            this.entityManager.merge(mapped);
        } else { // Search project by text-id received as parameter i.e. ProjectA
            ProjectResponse response = (ProjectResponse) this.entityManager.getEntity(project);
            tuple2 = projectsMethod.getProject(response.getId());
            this.entityManager.put(project, tuple2.getFirst());
        }
        this.response = tuple2.getSecond();
        this.entityManager.put(RESPONSE, tuple2.getSecond());
    }


    @Given("I create the following project:")
    public void iCreateTheFollowingProject(DataTable table) {
        Map<String, ProjectRequest> projects = table.asMap(String.class, ProjectRequest.class);
        Tuple2<ProjectResponse, Response> tuple2;
        for (Map.Entry<String, ProjectRequest> entry : projects.entrySet()) {
            tuple2 = this.projectsMethod.createProject(entry.getValue());
            this.entityManager.put(entry.getKey(), tuple2.getFirst());
            this.entityManager.put(RESPONSE, tuple2.getSecond());
        }
    }

    @And("the projects should have the following key-value")
    public void theProjectsShouldHaveTheFollowingKeyValue(DataTable table) {
        Map<String, ProjectResponse> projects = table.asMap(String.class, ProjectResponse.class);
        for (Map.Entry<String, ProjectResponse> entry : projects.entrySet()) {
            ProjectResponse expected = entry.getValue();
            ProjectResponse actual = (ProjectResponse) this.entityManager.getEntity(entry.getKey());
            Assert.assertEquals("Projects are not equals: ", expected, actual);
        }
    }

    @When("I delete {string} projects")
    public void iDeleteProjects(String project) {
        ProjectResponse projectResponse = (ProjectResponse) this.entityManager.getEntity(project);
        Tuple2<ProjectResponse, Response> tuple2 = this.projectsMethod.deleteProject(projectResponse.getId());
        this.entityManager.put(project, tuple2.getFirst());
        this.entityManager.put(RESPONSE, tuple2.getSecond());
    }

    @When("I update the following projects")
    public void iUpdateTheFollowingProjects(DataTable table) {
        Map<String, ProjectRequest> projects = table.asMap(String.class, ProjectRequest.class);
        for (Map.Entry<String, ProjectRequest> entry : projects.entrySet()) {
            ProjectResponse projectResponse = (ProjectResponse) this.entityManager.getEntity(entry.getKey());
            Tuple2<ProjectResponse, Response> tuple2 = this.projectsMethod.updateProject(projectResponse.getId(), entry.getValue());
            this.entityManager.put(entry.getKey(), tuple2.getFirst());
            this.entityManager.put(RESPONSE, tuple2.getSecond());
        }

    }
}
