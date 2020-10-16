package de.matejo.spockexample

import com.fasterxml.jackson.databind.ObjectMapper
import org.spockframework.spring.SpringBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

@WebMvcTest
class ControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    def objectMapper = new ObjectMapper()

    def "say hello"() {
        when: "uri is called"
        def response = mockMvc.perform(get("/hello")).andReturn().response

        then: "status code is 200 OK"
        response.status == HttpStatus.OK.value()
    }
}
