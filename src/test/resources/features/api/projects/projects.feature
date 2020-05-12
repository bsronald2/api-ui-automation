@projects @smoke @api
Feature: Testing Projects methods


  @GetAll
  Scenario: Get All Projects by Default
    When I get "all" projects
    Then the status code should be 200
      * the projects should have the following key-value
        |          | content          | itemsCount | icon | itemType |   collapsed | itemOrder | isProjectShared | isShareApproved | isOwnProject | deleted |
        | ProjectA | Work             | 5          | 10   | 2        |   false     |  1        | false           | false           | true         | false   |
        | ProjectB | Home             | 0          | 1    | 2        |   false     |  2        | false           | false           | true         | false   |
        | ProjectC | Study            | 0          | 4    | 2        |   false     |  3        | false           | false           | true         | false   |
        | ProjectD | Personal         | 0          | 6    | 2        |   false     |  4        | false           | false           | true         | false   |
        | ProjectE | Shopping List    | 0          | 14   | 2        |   false     |  5        | false           | false           | true         | false   |


  @Post @deleteProject
  Scenario: Post Projects
    When I create the following project:
      |          | content          |  icon |
      | ProjectA | Dissertation     |  9    |
      | ProjectB | Assignments      |  5    |
      | ProjectC | English          |  4    |
    Then the status code should be 200
      * the projects should have the following key-value
        |          | content          | itemsCount | icon | itemType |  parentId | collapsed |  isProjectShared | isShareApproved | isOwnProject | deleted |
        | ProjectA | Dissertation     | 0          | 9    | 2        |  null     | false     | false            | false           | true         | false   |
        | ProjectB | Assignments      | 0          | 5    | 2        |  null     | false     | false            | false           | true         | false   |
        | ProjectC | English          | 0          | 4    | 2        |  null     | false     | false            | false           | true         | false   |

  @Get @deleteProject
  Scenario: Post Projects
    Given I create the following project:
      |          | content          |  icon |
      | ProjectA | Dissertation     |  9    |
      * the status code should be 200
    When I get "ProjectA" projects
    Then the status code should be 200
      * the projects should have the following key-value
        |          | content          | itemsCount | icon | itemType |  parentId | collapsed |  isProjectShared | isShareApproved | isOwnProject | deleted |
        | ProjectA | Dissertation     | 0          | 9    | 2        |  null     | false     | false            | false           | true         | false   |

  @Delete
  Scenario: Post Projects
    Given I create the following project:
      |          | content          |  icon |
      | ProjectA | Dissertation     |  7    |
      * the status code should be 200
    When I delete "ProjectA" projects
    Then the status code should be 200
      * the projects should have the following key-value
        |          | content          | itemsCount | icon | itemType |  parentId | collapsed |  isProjectShared | isShareApproved | isOwnProject | deleted |
        | ProjectA | Dissertation     | 0          | 7    | 2        |  null     | false     | false            | false           | true         | true    |

  @Put @deleteProject
  Scenario: Post Projects
    Given I create the following project:
      |          | content   |  icon |
      | ProjectA | Tesis     |  7    |
    When I update the following projects
      |          | content   |  icon |
      | ProjectA | Tesis123  |  8    |
    Then the status code should be 200
    * the projects should have the following key-value
      |          | content    | itemsCount | icon | itemType |  parentId | collapsed |  isProjectShared | isShareApproved | isOwnProject | deleted |
      | ProjectA | Tesis123   | 0          | 8    | 2        |  null     | false     | false            | false           | true         | false   |
