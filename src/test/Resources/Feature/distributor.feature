Feature: To Validate the Distributor Page

  @locator
  Scenario: Validating a Distributor Page
    Given I open the HomePage website
    When I navigate to where to buy locator page
    And I enter "United States" in the search box
    Then the map should update to show distributors in US
    And the distributor list should show relevant names and addresses