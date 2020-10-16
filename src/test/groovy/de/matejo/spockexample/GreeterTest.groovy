package de.matejo.spockexample

import spock.lang.Specification

class GreeterTest extends Specification {

    def "greeter says hello"() {
        given: "the greeter "
        def greeter = new Greeter()

        when: "greeter is called with Flo"
        def response = greeter.sayHelloTo("Flo")

        then: "response is hello Flo"
        response == "hello Flo"
    }
}
