@user @smoke @api
Feature: Testing User methods

#  Scenario: Create User
#    When I create a new user
#    |       | email                | fullName  | password |
#    | UserA | example@example.com  | William M | M123!    |
#
#  Scenario: Delete User
#    Given I create a new user
#      |       | email                | fullName  | password |
#      | UserA | example@example.com  | William M | M123!    |
#    When I delete the next users
#      |       | email                | password |
#      | UserA | example@example.com  |  M123!   |

    Scenario: Get Users
      When I get "UserA" user
      Then the status code should be 200
      And "UserA" should have the following key-values
      | id      | email                        | fullName | timeZone | isProUser | defaultProjectId | addItemMoreExpanded | editDueDateMoreExpanded | listSortType | firstDayOfWeek | newTaskDueDate |
      | 645318  | r.butron.projects@gmail.com  | Ron      | 0        | false     | 3830462          | false               | false                   | 0            | 0              | -1             |
