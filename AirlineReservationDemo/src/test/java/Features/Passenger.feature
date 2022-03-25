Feature:
  Scenario: Verify one Passenger
    Given A List of Passengers
    And I Perform GET for the Passenger "123321"
    Then I Should see the FirstName "Philip"

  Scenario: Verify Passenger List
      Given A List of Passengers
      And I Perform GET for passenger list

  Scenario: Verify the Passenger with ID
      Given A List of Passengers
      And I Perform GET for one Passenger "123321"
      Then I Should see the list

  Scenario: Verify Adding Passenger
    Given A List of Passengers
    And I Add Passenger to List
    
  Scenario: Verify Updating Passengers
    Given A List of Passengers
    And I Perform UPDATE operation

  Scenario: Verify Deleting Passenger
      Given A List of Passengers
      And I Perform DELETE operation







