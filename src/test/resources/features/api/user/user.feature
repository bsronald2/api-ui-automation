@user @smoke @api @deleteUser
Feature: Testing User methods


  Background:
    Given I log in with the following user
      |       | email                 | fullName  | password |
      | UserA | example2@example.com  | William M | M123!    |

  @Post
  Scenario: Delete User
    Then the status code should be 200
      And "UserA" should have the following key-values
        | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
        | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |

  @Delete @NotDeleteUser
  Scenario: Delete User
    When I delete the next users
      | UserA |
    Then the status code should be 200
      And "UserA" should have the following key-values
        | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
        | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |

  @Get
  Scenario: Get Users
      When I get "UserA" user
      Then the status code should be 200
        And "UserA" should have the following key-values
        | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
        | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |

  @Put
  Scenario: Delete User
    When I update the following users
    |       | fullName        |
    | UserA | William Antonio |
    Then the status code should be 200
      * I get "UserA" user
      * the status code should be 200
    And "UserA" should have the following key-values
      | email                 | fullName       | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
      | example2@example.com  | William Antonio| 0        | false     |  false               | false                   | 0            | 0              | -1             |