@smoke
Feature: Selection of passport holder, destination, and purpose of travel

  Scenario: User apply for visa

    Given User select passport holder country
     And   User select the destination
     Then  User select the purpose of travel
     And   Click on set to go
     When  Page displayed
     And   Click on order now
     Then  Insert personal info
     And   Select payment option
     When  Click on revision and payment
     And   Select visa type
     Then  Insert visa details
     And   Click submit request
     And   Click pay now
#     When  Click continue, insert code and passcode
#    Then  User validate the visa paid and application created
