@Project
Feature: Project

  Background:
    Given I navigate at Login Page
      And I sing in successfully at Login Page
      And I navigate at New Project Page

  Scenario:Create a new project "Test" from a "Scrum" methodology template and with a advanced configuration

    When  I choose a methodology template
      And   I set the project details
      And   I set advanced project fields
      And   I created the project

    Then  I should be in a project "Test" page Overview
      And I have the  Project "Test" successfully created.
      And I have a Card Wall according with my choose template "Scrum"






