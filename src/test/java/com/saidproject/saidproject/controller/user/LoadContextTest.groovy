package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.controller.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spock.lang.Specification;
import groovy.lang.*;
import groovy.util.*;

@SpringBootTest
class LoadContextTest extends Specification {

    @Autowired (required = false)
    private UserController userController

    def "when context is loaded then all expected beans are created"() {
        expect: "the UserController is created"
        userController
    }
}
