Feature: Test filters for category page on Amazon website

  Scenario: Check brand selection filter
    Given User travels to "Category Page"
    When User selects a brand
    Then A search result list containing only that brand items should load on "Category Page"