
  Feature: Project

    Background:
      Given I sing in to page with the user "brayan_rosas" and password "Bgrf44360303bpm."

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
      Examples:
              | Project Name          | Project type  |
              | TestProjectKanban     | Kanban    |
              | TestProjectAgile      | Agile     |
              | TestProjectScrum      | Scrum     |
              | BlankProject          | Blank     |
    @Project
    Scenario: Can not create two projects with the same name
      Given I create the project with project name "TheSameName" and project type "Agile"
        And I go at my list projects
      When  I create the project with same project name "TheSameName" and type project "Agile"
      Then An Error message "Identifier has already been taken, Identifier is already used by an existing " should be displayed


    @Project
    Scenario: Invite a new users to project created
      Given I create the project with project name "Project1" and project type "Agile"
      When I invite a new user to the current project with the email "JeanCarlo.Rodriguez@fundacion-jala.org"
      Then  the user "JeanCarlo.Rodriguez@fundacion-jala.org" should be in the Team List of the project "Project1"


     Scenario: A template can be created to save structure of the project
        Given I create the project with project name "Project1" and project type "Agile"
         And I create a new Value "Product Backlog" on default Agile tab "Card Wall"
         And I create the card "UserStory"  inside the value "Product Backlog" with estimation "2" and owner "Brayan Rosas" and cardType "Story"
       When  I create a template of the project "Project1"
       Then the message "Template was successfully created." should be showed
       When delete the "Project1" project from the main page
       Then The template of project "Project1" is the template project list
















