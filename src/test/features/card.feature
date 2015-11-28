  @Cards
  Feature: Card

    Background:
      Given I create the project with project name "Agile project" and type project "Agile"

    Scenario: Create a new card "Write scenarios" inside to new Tab "DashBoard" and inside new Value "Product Backlog"
        And I create the  tab "DashBoard"
        And I create the Value "Product backlog"
      When I create the card "UserStory"  inside the Tab "DashBoard"  and inside of Value "Product backlog"
      Then An message "The card UserStory was created successfully" is displayed.
        And  the card is in the card list of the project
        And  the card is inside the Tab "DashBoard"
        And  The card is in the Value "Product backlog"
      Given Delete the "Agile project" project from the main page

    Scenario: The card can be moved to any Value of Tab of a project
        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "New"
      When The card is moved to any other Value e.g. "In Dev"
      Then The card now is in the Value "In Dev"
        And  The card's status is "In dev"
      Given Delete the "Agile project" project from the main page


    Scenario: When I change the card's status e.g. to "In Dev" , it should move to Value "In dev"
        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "New"
      When  I change the card's status to "In Dev"
      Then  The card now is in the Value "In Dev"
        And The card's status is "In Dev"
      Given Delete the "Agile project" project from the main page

    Scenario: A Value that was hidden with cards inside,can be show again using the value's search
        And Go to the Tab "Card Wall"
        And The Tab "Card Wall" have cards created by default "Story 1,Story 2,Story 3,Backlog" when was created the "Agile" project
      When  I hide the Value "New" of the Tab "Card Wall"
      Then The Value "New" is not in the Tab "Card Wall"
        And  The cards "Story 1,Story 2" that was in the Value is in the cards list
      When I search the Value "New"
        And  The Value "New" is founded
      Then The Value is showed in the Tab "Card Wall"
        And  The cards "Story 1,Story 2" should be in the Value "New"
      Given Delete the "Agile project" project from the main page

    Scenario: All cards that are in Card Wall that is working in Release 1 , should be showed in the Iteration Plan inside of Release 1
        And Go to the Tab "Card Wall"
        And The Tab "Card Wall" have cards created by default "Story 1,Story 2,Story 3,Backlog" when was created the "Agile" project
        And I create the card "UserStory"  inside the Tab "CardWall"  and inside of Value "Done"
      When I go to the Tab "Iteration Plan"
      Then The cards "Story 1,Story 2,Story 3,Backlog" ,are in the Value "Release 1"
        And  The cards "UserStory",are in the Value "Release 1"
      Given Delete the "Agile project" project from the main page



