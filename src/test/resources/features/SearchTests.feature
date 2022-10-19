Feature: Test search functionality for Amazon Home Page

  Scenario: Search with incorrect information
    Given User types incorrect search phrase "a,smnfkjehriirjkjfnkjcnk90039034854tuihdfkjdfjnknjse!!@#$%^&(*&^%$#@#$%^&*^%$#@kflnvmoashgsdkjfnlkejnskld" on "Home Page"
    When User clicks search button on "Home Page"
    Then User should see "No results for" error message on "Search Page"

  Scenario: Search with correct information
    Given User types correct search phrase as "laptop" on "Home Page"
    When User clicks search button on "Home Page"
    Then User should see number of results for "\"laptop\"" message on "Search Page"

  Scenario: Check the results list matches searched item on "Home Page"
    Given User types correct search phrase as "laptop" on "Home Page"
    When User clicks search button on "Home Page"
    Then User should see at least one result containing "laptop" keyword on "Search Page"