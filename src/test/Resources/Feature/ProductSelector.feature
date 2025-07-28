Feature:  Motor Oil Finder Functionality

  @Mobil
  Scenario: Select valid drop downs and view recommendation
    Given I open the Homepage website
    When I navigate to Find the Right Motor Oil
    And I select year "2019"
    And I select make "Audi"
    And I select model "A3"
    And I select engine "2.0L L4 (CZRA) Turbocharged GAS FI"
    And I click on view recommendations
    Then I should see the recommendation results
