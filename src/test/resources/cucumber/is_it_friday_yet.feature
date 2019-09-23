Feature: Is it friday yet?

    Everybody wants to know when it's friday

    Scenario: Sunday is not friday
        Given today is Sunday
        When I ask wheter it's Friday yet
        Then I should be told "Nope"

    Scenario: Friday is Friday
        Given today is Friday
        When I ask wheter it's Friday yet
        Then I should be told "Yep"