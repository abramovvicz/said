package com.saidproject.saidproject.controller.user

import com.saidproject.saidproject.service.user.UserService
import org.mapstruct.Named
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Specification

class UserControllerTest extends Specification {

    @Autowired @Named('userServiceMock')
    UserService userServiceMock

    void setup() {

    }

    def "FindById"() {
        when:
        def result = userServiceMock.testSth()

        then:
        result == "someUrl/?name=test%"
    }

    def "FindAll"() {
    }

    def "Save"() {
    }

    def "Update"() {
    }

    def "Delete"() {
    }
}
