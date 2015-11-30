  @Cards
  Feature: Card

    Background:
      Given I sing in to page with the user "brayan_rosas" and password "Bgrf44360303bpm."
     And I create the project with project name "Agile project" and project type "Agile"

    Scenario: Create a new card "Write scenarios" inside to Tab "Card Wall" and inside new Value "Product Backlog"

     When I create a new Value "Product Backlog" on default Agile tab "Card Wall"
      And I create the card "UserStory"  inside the value "Product Backlog" with estimation "2" and owner "Brayan Rosas" and cardType "Story"
     Then An message "was successfully created." is displayed
#        And  the card is in the card list of the project
#        And  the card is inside the Tab "DashBoard"
#        And  The card is in the Value "Product backlog"
      Given delete the "Agile project" project from the main page
#
#    Scenario: The card can be moved to any Value of Tab of a project
#        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "New"
#      When The card is moved to any other Value e.g. "In Dev"
#      Then The card now is in the Value "In Dev"
#        And  The card's status is "In dev"
#      Given Delete the "Agile project" project from the main page
#
#
#    Scenario: When I change the card's status e.g. to "In Dev" , it should move to Value "In dev"
#        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "New"
#      When  I change the card's status to "In Dev"
#      Then  The card now is in the Value "In Dev"
#        And The card's status is "In Dev"
#      Given Delete the "Agile project" project from the main page
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



