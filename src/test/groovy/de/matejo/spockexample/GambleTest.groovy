package de.matejo.spockexample

import spock.lang.Specification

class GambleTest extends Specification {

    def "use dice"() {
        given: "a Gamble class"
        Gamble gamble = new Gamble()
        and: "a dice mock"
        Dice diceMock = Mock()

        when: "assign prize is called"
        def result = gamble.assignPrice()

        then: "there should be a win"
        result == "you win"
    }
}
