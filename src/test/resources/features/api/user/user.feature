@user @smoke @api
Feature: Testing Cucumber

  Scenario: Create User
    When I create a new user
    | email                | fullName | password |
    | example@example.com  | William M| M123!    |