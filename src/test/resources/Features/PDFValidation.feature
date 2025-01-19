Feature: PDF validation feature

  @PDF 
  Scenario Outline: File download validation
    Given I hit the URL for Download
    When I download the file
    Then I validate the <expectedText> inside the file

    Examples: 
      | expectedText     |
      | THE BOND SEE-SAW |
      | aaaaaaa          |
