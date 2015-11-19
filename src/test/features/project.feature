@Project
  Feature: Project

  Background:
    Given I navigate at Login Page
    And I sing in successfully at Login Page

  @SmokeTest
  Scenario Outline: Create a new Project
    When I navigate to New Project Page
      And I fill the "<projectName>"
      And I create the project
    Then I have the  Project "<projectName>" successfully created.
      And  I have the "<projectName>" on the  project list
      And I go to project admin
      And I sing out of page
     Examples:
    | projectName        | template|
    #| TestProjectKanban  | Kanban  |
     | TestProjectAgile   | Agile   |
    #| TestProjectScrum   | Scrum   |

  Scenario: Delete a new project that had been created
   Given I have a new project with "projectName" created
   When  I go to project admin
      And  I select the project with "projectName"
      And  I click on the delete
      And  I type the "<projectName>" to confirm the deleting of project
   Then The project with the name "projectName" has been deleted successfully
   When I sing out of page


#Scenario:Create a new project "Test" from a "Scrum" methodology template and with a advanced configuration

    #When  I type the project name
     #And  I choose the project template
     #And  I set advanced project fields
     #And  I created the project
    #Then  I should be in a project "Test" page Overview
     #And  I have the  Project "Test" successfully created.
     #And  I have a Card Wall according with my choose template "Scrum"

    Scenario Outline: Create a project with different template types
      And  I navigate to New Project Page
     When  I fill the "<projectName>"
       And  I choose a methodology "<template>"
       And  I set advanced project fields
       And  I create the project
     Then I should  in a project "<projectName>" page Overview
       And  the  Project "<projectName>" should be successfully created.
       And  the menu option "<typeCard>" is displayed according "<template>"
       And  I have the "<projectName>" on the  project list
      Examples:
      | Project Name         | Template  |TypeCard |
      | Test Project Kanban  | Kanban    | Kanban  |
      | TestProjectAgile     | Agile     | Card    |
      | TestProjectScrum     | Scrum     | Sprint  |

 # Scenario: Modify  a project that was been created

  #  Given I have a project created with the name "Test"
   # When  I modify all project's properties
    #Then  I have a project with all properties modified.

  #Scenario: User do not enroll in the project with the property "enroll" disable
   # Given I have a project with enroll property disable
    #When  A manager of the project want to enroll a some user
    #Then  The user should not be created.











