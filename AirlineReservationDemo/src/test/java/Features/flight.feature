Feature:
  Scenario:
    Given A List of Flights
    And I perform GETALL flight
    Then I Should see the list of flights

  Scenario:
    Given A List of Flights
    And I perform POST operation

  Scenario:
      Given A List of Flights
      And I perform GET for one flight "CP321"
      Then I Should see the flight

  Scenario:
          Given A List of Flights
          And I Perform UPDATE operation for flights

  Scenario:
            Given A List of Flights
            And I Perform DELETE operation for flights


