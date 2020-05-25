package com.auto.ui.pages.sidebar

import com.auto.api.entities.projects.ProjectRequest
import com.auto.api.entities.projects.ProjectResponse
import com.auto.api.entities.projects.ProjectResponseBuilder
import com.auto.entities.IconEnum
import com.auto.ui.pages.AbstractBasePage
import com.auto.ui.pages.common.CommonActions
import com.auto.ui.pages.common.UICommonMethods
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions

class LeftSideBar extends AbstractBasePage {

    @FindBy(css = "div#FilterListPlaceHolder div[itemid=\"0\"]")
    WebElement inboxFilter

    @FindBy(xpath = "//td[@class=\"ProjItemContent\" and contains(., \"Add New Project\")]")
    WebElement addNewProjectBtn

    @FindBy(id = "NewProjNameInput")
    WebElement newProjNameInput

    @FindBy(id = "NewProjNameButton")
    WebElement newProjNameBtn


    /**
     * Add new Project.
     *
     * @param name
     */
    public void addNewProject(String name) {
        CommonActions.clickElement(addNewProjectBtn)
        CommonActions.sendKeys(newProjNameInput, name)
        CommonActions.clickElement(newProjNameBtn)

        // Added wait in order to load Current Project
        By byCurrentProj = By.xpath("//div[@id='CurrentProjectTitle' and contains(., ${name})]")

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(byCurrentProj)));
        CommonActions.clickElement(addNewProjectBtn)
    }

    /**
     * Select icon for project.
     *
     * @param request
     */
    public ProjectResponse selectIcon(ProjectRequest request) {
        WebElement elementProject = getProjectWebElement(request.content)
        final String projectId = elementProject.getAttribute("itemid")

        ContextMenu contextMenu = clickOnProjectOptions(elementProject)
        contextMenu.clickOnIcon(Integer.toString(request.icon))

        return new ProjectResponseBuilder()
                .id(Integer.parseInt(projectId))
                .build()
    }


    /**
     * Click on project options icon.
     *
     * @param elementProject
     * @return Context Menu
     */
    public ContextMenu clickOnProjectOptions(WebElement elementProject) {
        final String projectId = elementProject.getAttribute("itemid")

        By byOption = By.xpath("//div[@class='ProjItemMenu'and @itemid='${projectId}']")
        //Click on Options Drop Down Button
        Actions actions = new Actions(driver)
        actions.moveToElement(elementProject)
                .moveToElement(driver.findElement(byOption))
                .click()
                .build()
                .perform()

        return new ContextMenu()
    }

    /**
     * Retrieve Project Element.
     *
     * @param projectName
     * @return
     */
    public WebElement getProjectWebElement(String projectName) {
        final By byProject = By.xpath("//td[@class='ProjItemContent' and contains(., '$projectName')]")

        return driver.findElement(byProject)
    }

    /**
     * Add project and set up new Icon.
     *
     * @param request
     * @return Project Response entity for further post execution tasks.
     */
    public ProjectResponse addProjectWithIcon(ProjectRequest request) {
        addNewProject(request.content)
        return selectIcon(request)
    }

    /**
     * Verify is Project was created successfully.
     *
     * @param projectResponse
     * @return true if element is present otherwise false
     */
    public boolean isProjectDisplayed(ProjectResponse projectResponse) {
        String iconName = IconEnum.getNameById(projectResponse.icon)
        By byCss = By.xpath("//td[@class='ProjItemContent' " +
                "and contains(., '${projectResponse.content}')]/preceding-sibling::td/div[contains(., ${iconName.toLowerCase()})]")

        return UICommonMethods.isElementPresent(byCss)
    }
}
