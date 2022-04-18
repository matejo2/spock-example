package de.matejo.spockexample

import spock.lang.Specification
import spock.lang.Unroll

class GambleTest extends Specification {

    def "win on a rolled 6"() {
        given: "a Gamble class"
        Dice diceMock = Mock()
        Gamble gamble = new Gamble(diceMock)
        and: "the dice rolls once and returns a 6"
        1 * diceMock.roll() >> 6

        when: "assign prize is called"
        def result = gamble.assignPrice()

        then: "there should be a win"
        result == "you win"
    }

    def "loose when a 5 is rolled"() {
        given: "a Gamble class"
        Dice diceMock = Mock()
        Gamble gamble = new Gamble(diceMock)

        when: "assign prize is called"
        def result = gamble.assignPrice()

        then: "there should be a loss"
        result == "you loose :("
        and: "the dice rolls once and returns a 5"
        1 * diceMock.roll() >> 5
    }

    @Unroll
    def "#WinOrLoose when a #number is rolled"() {
        given: "a Gamble class"
        Dice diceMock = Mock()
        Gamble gamble = new Gamble(diceMock)

        when: "assign prize is called"
        def result = gamble.assignPrice()

        then: "there should be a loss"
        result == expectedResult
        and: "the dice rolls once and returns a 5"
        1 * diceMock.roll() >> number

        where:
        number | expectedResult | WinOrLoose
        1      | "you loose :(" | "loose"
        2      | "you loose :(" | "loose"
        3      | "you loose :(" | "loose"
        4      | "you loose :(" | "loose"
        5      | "you loose :(" | "loose"
        6      | "you win"      | "win"
        -1     | "error"        | "error"
    }
}
