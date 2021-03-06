@Login
Feature: Login

  Scenario Outline:Sing in with wrong credentials

   When I sing in to page with invalid credentials "<user>" and "<password>"
   Then A error message should be displayed
   Examples:
     | user         | password       |
     | invalidUser  | wrongPassword  |
     |  $**///      | @*/(*856       |

  Scenario Outline: Sing in with user name or user email and password

   When I sing in to main page with valid credentials "<user>" and "<password>"
   Then I should login to Mingle successfully
   And I sing out of page
   Examples:
    | user                            | password        |
    | brayan_rosas                    | Bgrf44360303bpm.|
    | Brayan.Rosas@fundacion-jala.org | Bgrf44360303bpm.|



