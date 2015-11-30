  @Cards
  Feature: Card

    Background:
      Given I sing in to page with the user "brayan_rosas" and password "Bgrf44360303bpm."
     And I create the project with project name "Agile" and project type "Agile"

    Scenario: Create a new card "Write scenarios" inside to Tab "Card Wall" and inside new Value "Product Backlog"
     When I create a new Value "Product Backlog" on default Agile tab "Card Wall"
      And I create the card "UserStory"  inside the value "Product Backlog" with estimation "2" and owner "Brayan Rosas" and cardType "Story"
     Then An message "was successfully created." is displayed
      And  the card "UserStory" is inside the Value "Product Backlog"
      And  the card "UserStory" is in the card list of the project
      Given delete the "Agile project" project from the main page

    Scenario: The card can be moved to any Value of Tab of a project
      Given  I create a new Value "Product Backlog" on default Agile tab "Card Wall"
        And I create the card "UserStory"  inside the value "Product Backlog" with estimation "2" and owner "Brayan Rosas" and cardType "Story"
      When the card "UserStory" is moved from "Product Backlog" to "In Dev" Value in the Tab "Card Wall"
      Then the card "UserStory" is inside the Value "In Dev"
        #And  The card's status is "In dev"
      Given delete the "Agile project" project from the main page


    Scenario: When I change the card's status e.g. to "In Dev" , it should move to Value "In dev"

      Given  I create a new Value "Product Backlog" on default Agile tab "Card Wall"
        And I create the card "UserStory"  inside the value "Product Backlog" with estimation "2" and owner "Brayan Rosas" and cardType "Story"
      When  I change the status of card "UserStory" to "In Dev" in the value "Product Backlog"
      Then the card "UserStory" is inside the Value "In Dev"
      Given delete the "Agile project" project from the main page
#
#    Scenario: A Value that was hidden with cards inside,can be show again using the value's search
#        And Go to the Tab "Card Wall"
#        And The Tab "Card Wall" have cards created by default "Story 1,Story 2,Story 3,Backlog" when was created the "Agile" project
#      When  I hide the Value "New" of the Tab "Card Wall"
#      Then The Value "New" is not in the Tab "Card Wall"
#        And  The cards "Story 1,Story 2" that was in the Value is in the cards list
#      When I search the Value "New"
#        And  The Value "New" is founded
#      Then The Value is showed in the Tab "Card Wall"
#        And  The cards "Story 1,Story 2" should be in the Value "New"
#      Given Delete the "Agile project" project from the main page
#
#    Scenario: All cards that are in Card Wall that is working in Release 1 , should be showed in the Iteration Plan inside of Release 1
#        And Go to the Tab "Card Wall"
#        And The Tab "Card Wall" have cards created by default "Story 1,Story 2,Story 3,Backlog" when was created the "Agile" project
#        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "Done"
#      When I go to the Tab "Iteration Plan"
#      Then The cards "Story 1,Story 2,Story 3,Backlog" ,are in the Value "Release 1"
#        And  The cards "UserStory",are in the Value "Release 1"
#      Given Delete the "Agile project" project from the main page



