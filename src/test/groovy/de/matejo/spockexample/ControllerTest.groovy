package de.matejo.spockexample

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import spock.lang.Ignore
import spock.lang.Specification

@WebMvcTest
class ControllerTest extends Specification {

    @Autowired
    MockMvc mockMvc

    def "Get single user returns 200 OK"() {
        given: "a uri"
        def uri = "/users/1"

        def user = new User(1L, "foo", "bar")
        def objectMapper = new ObjectMapper()

        when: "uri is called"
        def response = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn().response

        then: "response is OK"
        response.status == HttpStatus.OK.value()

        and: "body is a list of users"
        response.getContentAsString() == objectMapper.writeValueAsString(user)
    }

    @Ignore
    def "Get all users returns 200 OK"() {
        given: "a uri"
        def uri = "/users"

        def users = [new User(1L, "foo", "bar")]

        when: "uri is called"
        def response = mockMvc.perform(MockMvcRequestBuilders.get(uri)).andReturn().response

        then: "response is OK"
        response.status == HttpStatus.OK.value()

        and: "body is a list of users"
        response.getContentAsString() == users.toString()
    }
}
