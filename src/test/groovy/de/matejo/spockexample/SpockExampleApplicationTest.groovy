package de.matejo.spockexample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class SpockExampleApplicationTest extends Specification {

    @Autowired
    private SpockExampleApplication application

    def "startup works" () {
        expect:
        application != null
    }
}
