@user @smoke @api @deleteUser
Feature: Testing User methods

  @Post
  Scenario: Delete User
    When I log in with the following user
      |       | email                 | fullName  | password |
      | UserA | example2@example.com  | William M | M123!    |
    Then the status code should be 200
    And "UserA" should have the following key-values
      | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
      | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |

  @Delete @NotDeleteUser
  Scenario: Delete User
    Given I log in with the following user
      |       | email                 | fullName  | password |
      | UserA | example2@example.com  | William M | M123!    |
    When I delete the next users
      | UserA |
    Then the status code should be 200
    And "UserA" should have the following key-values
      | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
      | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |

  @Get
  Scenario: Get Users
      Given I log in with the following user
        |       | email                 | fullName  | password |
        | UserA | example2@example.com  | William M | M123!    |
      When I get "UserA" user
      Then the status code should be 200
      And "UserA" should have the following key-values
      | email                 | fullName | timeZone | isProUser |  addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
      | example2@example.com  | William M| 0        | false     |  false               | false                   | 0            | 0              | -1             |