
  Feature: Sign Up new account

    Scenario: User register new account

      Given User click on my account
        And  User click on sign up
        Then Insert First Name
        And  Insert Last Name
        Then Insert Email
        And  Insert Password and Confirm password
        When User clicked on sign up button
      Then  Success message will displayed