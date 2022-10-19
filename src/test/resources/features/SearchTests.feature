Feature: Test search functionality for Amazon website
  Scenario: Search with incorrect information
    Given User is on "Home Page"
    When User enters search phrase as "a,smnfkjehriirjkjfnkjcnk90039034854tuihdfkjdfjnknjse!!@#$%^&(*&^%$#@#$%^&*^%$#@kflnvmoashgsdkjfnlkejnskld"
    Then User should see "No results for" error message on "Search Page"

  Scenario: Search with correct information
    Given User is on "Home Page"
    When User enters search phrase as "laptop"
    Then User should see "\"laptop\"" message on "Search Page"

  Scenario: Check the results list matches searched item
    Given User is on "Home Page"
    When User enters search phrase as "laptop"
    Then User should see at least one result containing "laptop" keyword on "Search Page"