package com.auto.ui.steps;

import com.auto.api.entities.projects.ProjectRequest;
import com.auto.api.entities.projects.ProjectResponse;
import com.auto.ui.pages.MainPage;
import com.auto.ui.pages.sidebar.LeftSideBar;
import com.auto.utils.Constants;
import com.auto.utils.EntityManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class LeftSideBarSteps {

    private MainPage mainPage;
    private EntityManager entityManager;

    public LeftSideBarSteps(EntityManager entityManager) {
        this.entityManager = entityManager;
        mainPage = (MainPage) entityManager.getEntity(Constants.MAIN__PAGE);
    }


    @When("I create the following project by UI:")
    public void iCreateTheFollowingProjectByUI(DataTable table) {
        Map<String, ProjectRequest> projects = table.asMap(String.class, ProjectRequest.class);
        for (Map.Entry<String, ProjectRequest> entry : projects.entrySet()) {
            ProjectRequest projectRequest = entry.getValue();
            LeftSideBar leftSideBar = mainPage.getLeftSideBar();
            this.entityManager.put(entry.getKey(), leftSideBar.addProjectWithIcon(projectRequest));
        }
    }

    @Then("the projects should be displayed:")
    public void theProjectsShouldBeDisplayed(DataTable table) {
        Map<String, ProjectResponse> projects = table.asMap(String.class, ProjectResponse.class);
        for (Map.Entry<String, ProjectResponse> entry : projects.entrySet()) {
            ProjectResponse projectResponse = entry.getValue();
            LeftSideBar leftSideBar = mainPage.getLeftSideBar();
            Assert.assertTrue("Project " + projectResponse.getContent() + " was not created",
                    leftSideBar.isProjectDisplayed(projectResponse));
        }
    }
}
