package com.saidproject.saidproject.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    UserController userController

    def "when context is loaded then all expected beans are created"() {
        expect: "the UserController is created"
        userController
    }
}
