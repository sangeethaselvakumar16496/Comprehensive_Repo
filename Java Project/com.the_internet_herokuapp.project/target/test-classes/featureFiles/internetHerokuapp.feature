Feature: The Internet Herokuapp

  @regression
  Scenario Outline: Link validations - Internet herokuapp launch page
    Given user navigates to the application
    And verifies the main page title: "<mainPage_Title>"
    When user clicks on "A/B Testing" link
    And verifies the text on the page: "<abTestPage_textValidation>"
    Then user navigates back to homepage
    And user clicks on "Dropdown" link
    Then selects the dropdown value as "<dropDownValue>"
    And user navigates back to homepage
    Then user clicks on "Frames" link
    And verifies the below hyperlinks are presented on the frames page
      | Nested Frames |
      | iFrame        |

    Examples: 
      | mainPage_Title | abTestPage_textValidation                  | dropDownValue |
      | The Internet   | A/B Test Variation 1 (or) A/B Test Control | Option 1      |
