@ui @projects_ui
Feature: Testing Cucumber UI folder

  @deleteProject
  Scenario: Create a Project
    When I create the following project by UI:
      |          | content          |  icon |
      | ProjectA | Dissertation     |  9    |
      | ProjectB | Assignments      |  5    |
      | ProjectC | English          |  4    |
    Then the projects should be displayed:
      |          | content          |  icon |
      | ProjectA | Dissertation     |  9    |
      | ProjectB | Assignments      |  5    |
      | ProjectC | English          |  4    |
