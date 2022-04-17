package de.matejo.spockexample

import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest
class ControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    @SpringBean
    private Greeter greeter = Mock()

    def "mock spy thing"() {
        given:
        1 * greeter.sayHelloTo("bla") >> "return this"
        Controller controller = new Controller(greeter)

        when:
        def response = controller.sayHelloTo("bla")

        then:
        response == "return this"
    }

    def "say hello"() {
        when: "uri is called"
        def response = mockMvc.perform(get("/hello")).andReturn().response

        then: "status code is 200 OK"
        response.status == HttpStatus.OK.value()
        and: "response is hello"
        response.getContentAsString() == "hello"
    }

    def "say hello to Foobar"() {
        given:
        def givenName = "foobar"
        def expectedResponse = "hello foobar"
        1 * greeter.sayHelloTo(givenName) >> expectedResponse

        when: "url with name is called"
        def response = mockMvc.perform(get("/hello/$givenName")).andReturn().response

        then: "status code is 200 OK"
        response.status == HttpStatus.OK.value()
        and: "response is hello foobar"
        response.getContentAsString() == expectedResponse
    }

    @Unroll
    def "say hello to #givenName"() {
        when: "url with name is called"
        def response = mockMvc.perform(get("/hello/$givenName")).andReturn().response

        then: "status code is 200 OK"
        response.status == HttpStatus.OK.value()
        and: "response is hello Flo"
        response.getContentAsString() == expectedResponse
        and: "greeter do some logic"
        1 * greeter.sayHelloTo(givenName) >> expectedResponse

        where:
        givenName | expectedResponse
        "Flo"     | "hello Flo"
        "Jo"      | "hello Jo"
    }
}
