@Login
Feature: Verify SST Login Deatils

  Background: 
    Given User is on the SST login Page

  Scenario Outline: Verify SST Login With Valid Deatils
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify After Login Success Message "Dashboard"

    Examples: 
      | UserName      | Password   |
      | admin@SST.com | Pass@word1 |

  Scenario Outline: Verify SST Login Using Enter
    When User Should Perform Login "<UserName>","<Password>" With Enter Key
    Then User Should Verify After Login Success Message "Dashboard3"

    Examples: 
      | UserName      | Password   |
      | admin@SST.com | Pass@word1 |

  Scenario Outline: Verify SST Login Invalid Credentials
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify After Login With Invalid Credentials Error Message Contains "Invalid login attempt3."

    Examples: 
      | UserName      | Password |
      | admin@SST.com | Pass@wo  |

  Scenario Outline: Verify SST Login field is required Credentials
    When User should perform Login Without Credintials
    Then User should verify After Login With field is required Credentials Error Message as "The Email field is required." and "The Password field is required."

  Scenario Outline: Verify SST Login Email field is required Credentials
    When User should perform Login With wrong Credintials "<UserName>"
    Then User should verify After Login With field is required Credentials Error Message as "The Email field is not a valid e-mail address."

    Examples: 
      | UserName |
      | admin    |

  @Sorting
  Scenario Outline: Verify SST Login With Valid Deatils
    When User Should Perform Login "<UserName>","<Password>"
    Then User Should Verify After Login Success Message "Dashboard"
    When user should click organization
    And user should get data for sort

    Examples: 
      | UserName      | Password   |
      | admin@SST.com | Pass@word1 |
