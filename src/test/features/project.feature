  @Project
  Feature: Project

    Background:
      Given I sing in to page with "brayan_rosas" and "Bgrf44360303bpm."

    Scenario Outline: Create a project with different template types
        And I navigate to New Project Page
      When I fill the "<Project Name>"
        And I choose a project type "<Project type>"
        And I set advanced project fields: "label=(GMT-04:00) La Paz", "label=dd/mm/yyyy","3","C:\\Users\\BrayanRosas\\Pictures\\ProjectImages\\TestImage.jpeg"
        And I save the project
      Then  a new project page with the project name "<Project Name>" should be created
        And the project name "<Project Name>" is in the message "successfully created."
        And I have the "<Project Name>" on the  project list
      Given delete the "<Project Name>" project from the main page
       And I sing out of page from specific project
      Examples:
              | Project Name          | Project type  |
              | TestProjectKanban     | Kanban    |
              | TestProjectAgile      | Agile     |
              | TestProjectScrum      | Scrum     |
              | BlankProject          | Blank     |

    Scenario: Can not create two projects with the same name
      Given I create the project with project name "TheSameName" and project type "Blank"
        And I go at my list projects
      When  I create the project with same project name "TheSameName" and type project "Blank"
      #Then  I am not in the Page project "TheSameName"
      And An Error message "Identifier has already been taken, Identifier is already used by an existing " should be displayed
      Given delete the "TheSameName" project from the main page
        And I sing out of page from specific project

    Scenario: Invite two new users to project created
      Given I create the project with project name "Project1" and project type "Blank"
        When invite a new user to the current project with the email "JeanCarlo.Rodriguez@fundacion-jala.org"
      Then  the user "JeanCarlo.Rodriguez@fundacion-jala.org" should be in the Team List of the project "Project1"
      Given delete the "Project1" project from the main page
      And I sing out of page from specific project

    Scenario Scenario Outline:All users that belong at same project can write and read murmurs
      Given I create the project with project name "Project1" and project type "Blank"
        And have At least two users "User1", "User2" in the "Project1"
      When  the user with the email "<email>" writes a murmurs message "<message>" in the "Project"
            Examples:
                    | email                                       | message                      |
                    | Tester1@fundacion-jala.org                  | What is simple for Agile ?   |
                    | Tester2@fundacion-jala.org                  | hehehe,easy , simple is TUBE |
      And  I go to the "Project1" page.
        And The "User1" writes a message "message1"
        And The "User2" writes a message "message2"
      Then  In the murmurs list should be displayed the message "message1" with author "User1"
        And The "message2" with author "User2"
        And The "User1" should see all murmurs
        And The "User2" should see all murmurs
      Given delete the "Blank" project from the main page


#   Scenario: When delete a personalized project that have been exported , is possible to recovery all project configuration , importing the project.
#
#    Given I create the project with project name "Project1" and type project "Blank"
#      And I create the  tab "DashBoard"
#      And I create the card "UserStory"  inside the tab "DashBoard"
#      And I invite at "User1@fundacion-jala.org" at the project "Project1"
#    When  I export the project "Project1" to file "project1.mingle"
#      And I delete the project "Project1"
#      And I go to mainPage
#      And I import the project from file "project1.mingle"
#    Then  The project should be imported successfully
#      And the tab "DashBoard" exists in the project
#      And the card "UserStory" exists
#      And the user "User1@fundacion-jala.org" exits
#     Given Delete the "Blank" project from the main page













